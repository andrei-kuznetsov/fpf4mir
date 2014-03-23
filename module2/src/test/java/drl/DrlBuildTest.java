package drl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Ignore;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildSystem;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildSystem.BUILD_SYSTEMS;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.BuildErrorFixed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven.MvnBuild;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven.MvnErr_UnmappableCharacter;
import utils.AgendaListener;
import utils.DrlObjectsUtils;

public class DrlBuildTest {

	private static final String DRL_FILENAME = "build.drl";

	@Test
	@Ignore
	public void newMvnBuildTest() throws URISyntaxException  {
		StatefulKnowledgeSession ksession = DrlObjectsUtils.prepareStatefullSession(DRL_FILENAME);
        
        AgendaListener al = new AgendaListener();

        ksession.addEventListener(al);
        ksession.insert(new BuildSystem(BUILD_SYSTEMS.MAVEN));
        
        ksession.fireAllRules();
        
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        assertTrue(al.getFiredRules().contains("NewBuild_Mvn"));
        
        Collection<Object> objects = ksession.getObjects();
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(MvnBuild.class));
        assertEquals(1, omap.get(MvnBuild.class).size());
        
        // Set status (false) and Fire yet another time
        MvnBuild b = (MvnBuild) omap.get(MvnBuild.class).get(0);
        ExecStatus status = new ExecStatus(b, null, 1, null, null);
        ksession.insert(status);
        
        // Should not see new build because we didn't fix previous build yet
        ksession.fireAllRules();
        objects = ksession.getObjects();
        omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(MvnBuild.class));
        assertEquals(1, omap.get(MvnBuild.class).size());
        
        // Now fix the build
        BuildErrorFixed fix = new BuildErrorFixed(new MvnErr_UnmappableCharacter(b, ""));
        ksession.insert(fix);
        ksession.fireAllRules();
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        objects = ksession.getObjects();
        omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(MvnBuild.class));
        assertEquals(2, omap.get(MvnBuild.class).size());
        
        ksession.dispose();
	}
}

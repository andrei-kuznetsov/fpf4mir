package drl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.junit.Ignore;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunSystem;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunSystem.RUN_SYSTEMS;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.RunError;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.RunErrorFixed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java.JavaRun;
import utils.AgendaListener;
import utils.DrlObjectsUtils;

public class DrlTestRunTest {

	private static final String DRL_FILENAME = "testrun.drl";

	@Test
	@Ignore
	public void newTestRunTest() throws URISyntaxException  {
		StatefulKnowledgeSession ksession = DrlObjectsUtils.prepareStatefullSession(DRL_FILENAME);
        
        AgendaListener al = new AgendaListener();

        ksession.addEventListener(al);
        ksession.insert(new RunSystem(RUN_SYSTEMS.JAVA));
        
        ksession.fireAllRules();
        
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        assertTrue(al.getFiredRules().contains("NewTestRun_Java"));
        
        Collection<Object> objects = ksession.getObjects();
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(JavaRun.class));
        assertEquals(1, omap.get(JavaRun.class).size());
        
        // Set status (false) and Fire yet another time
        JavaRun b = (JavaRun) omap.get(JavaRun.class).get(0);
        FactHandle hb = ksession.getFactHandle(b);
        ExecStatus status = new ExecStatus(b, null, 1, null, null);
        ksession.insert(status);
        
        // Should not see new run because we didn't fix previous build yet
        ksession.fireAllRules();
        objects = ksession.getObjects();
        omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(JavaRun.class));
        assertEquals(1, omap.get(JavaRun.class).size());
        
        // Now fix the run
        RunErrorFixed fix = new RunErrorFixed(new RunError(b, "message"));
        ksession.insert(fix);
        ksession.fireAllRules();
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        objects = ksession.getObjects();
        omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(JavaRun.class));
        assertEquals(2, omap.get(JavaRun.class).size());
        
        ksession.dispose();
	}
}

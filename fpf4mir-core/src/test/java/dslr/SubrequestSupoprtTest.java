package dslr;

import junit.framework.TestCase;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.Alias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.GenericRequestSucceeded;
import utils.AgendaListener;
import utils.DrlObjectsUtils;

public class SubrequestSupoprtTest extends TestCase {
	
	private static final String DRL_FILENAME = "subrequests_support.dslr";

	@Test
	public void testRule__Process_any_Request_result_successfull() throws InstantiationException, IllegalAccessException{
		StatefulKnowledgeSession ksession = DrlObjectsUtils.prepareStatefullSessionDslr(DRL_FILENAME);
        
        AgendaListener al = new AgendaListener();

        Logger.getLogger(AgendaListener.class).setLevel(Level.DEBUG);
        
        ksession.addEventListener(al);
        
        FileArtifact retObj = new GenericFileArtifact();
        
        Activity da = (Activity) DrlObjectsUtils.createObject(ksession, "defaultpkg", "DeployExecutableActivity");
        Request subreq = (Request) DrlObjectsUtils.createObject(ksession, "defaultpkg", "ReqGuessRunExecutable");
        DrlObjectsUtils.setField(ksession, subreq, "activity", da);
        RequestSucceeded subreq_success = new GenericRequestSucceeded();
        subreq_success.setRequest(subreq);

        Alias subreq_success_fact = (Alias) DrlObjectsUtils.createObject(ksession, "defaultpkg", "ExecFileArtifactListAlias");
        subreq_success_fact.setRefObject(retObj);
        DrlObjectsUtils.setField(ksession, subreq_success_fact, "rstatus", subreq_success);
        
        ksession.insert(da);
        ksession.insert(subreq);
        ksession.insert(subreq_success_fact);
        ksession.insert(subreq_success);
        
        
        
        ksession.fireAllRules();
        /*
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        assertTrue(al.getFiredRules().contains("NewBuild_Mvn"));
        
        Collection<Object> objects = ksession.getObjects();
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(MvnBuild.class));
        assertEquals(1, omap.get(MvnBuild.class).size());
        
        // Set status (false) and Fire yet another time
        MvnBuild b = (MvnBuild) omap.get(MvnBuild.class).get(0);
        ActionStatus status = new ExecStatus(b, null, 1, null, null);
        ksession.insert(status);
        
        // Should not see new build because we didn't fix previous build yet
        ksession.fireAllRules();
        objects = ksession.getObjects();
        omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(MvnBuild.class));
        assertEquals(1, omap.get(MvnBuild.class).size());
        
        // Now fix the build
        BuildErrorFixed fix = null;//TODO: new BuildErrorFixed(new JavacErr_UnmappableCharacter(b, ""));
        ksession.insert(fix);
        ksession.fireAllRules();
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        objects = ksession.getObjects();
        omap = DrlObjectsUtils.convertToMap(objects);
        assertTrue(omap.containsKey(MvnBuild.class));
        assertEquals(2, omap.get(MvnBuild.class).size());
        */
        ksession.dispose();
	}
}

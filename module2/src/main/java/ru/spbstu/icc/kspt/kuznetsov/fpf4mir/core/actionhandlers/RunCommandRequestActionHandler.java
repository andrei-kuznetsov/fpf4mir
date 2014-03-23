package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import java.io.File;

import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ActionFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.RunCommandRequestAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunSystem;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunSystem.RUN_SYSTEMS;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java.JavaRunExecutableArtifact;

public class RunCommandRequestActionHandler implements ActionHandler {
	public void process(ActionFact a, StatefulKnowledgeSession ksession){
		final RunCommandRequestAction action = (RunCommandRequestAction)a;
		
		File build_wd = action.getStatus().getExecCommand().getWorkingDir();
		File jar = new File(build_wd, "target/dist/chordest.jar");
		
		ksession.retract(ksession.getFactHandle(action));
		ksession.insert(new JavaRunExecutableArtifact(jar));
		ksession.insert(new RunSystem(RUN_SYSTEMS.JAVA));
	}
}

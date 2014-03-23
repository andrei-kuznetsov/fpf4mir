package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ActionFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.DetectEncodingAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.sources.SrcEncoding;

public class DetectEncodingActionHandler implements ActionHandler {
	public void process(ActionFact a, StatefulKnowledgeSession ksession){
		final DetectEncodingAction action = (DetectEncodingAction)a;
		
		ksession.retract(ksession.getFactHandle(action));
		ksession.insert(new SrcEncoding("Windows-1251"));
	}
}

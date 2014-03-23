package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ActionFact;

public interface ActionHandler {
	public void process(ActionFact action, StatefulKnowledgeSession ksession) throws Exception;
}

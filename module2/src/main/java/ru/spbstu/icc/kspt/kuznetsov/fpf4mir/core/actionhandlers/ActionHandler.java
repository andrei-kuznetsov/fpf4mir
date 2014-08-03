package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;

public interface ActionHandler {
	public void process(Action action, StatefulKnowledgeSession ksession) throws Exception;
}

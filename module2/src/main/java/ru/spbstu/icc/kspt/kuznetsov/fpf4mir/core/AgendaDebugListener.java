package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.definition.rule.Rule;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.drools.event.rule.WorkingMemoryEventListener;

public class AgendaDebugListener implements WorkingMemoryEventListener {

	private static final Logger log;
	
	static {
		log = Logger.getLogger(AgendaDebugListener.class);
		log.setLevel(Level.ALL);
	}
	
	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		Rule r = event.getPropagationContext().getRule();
		String rule = "unknown rule";
		if (r != null) rule = r.getName();
			
		rule = "'" + rule + "'";
		log.debug(rule + " inserted: " + event.getObject());
	}

	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		log.debug("updated: " + event.getOldObject() + " -> " + event.getObject());
	}

	@Override
	public void objectRetracted(ObjectRetractedEvent event) {
		log.debug("retracted: " + event.getOldObject());
	}

}

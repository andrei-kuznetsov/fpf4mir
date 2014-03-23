package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import org.apache.log4j.Logger;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.drools.event.rule.WorkingMemoryEventListener;

public class AgendaDebugListener implements WorkingMemoryEventListener {

	private static final Logger log = Logger.getLogger(Main.class);
	
	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		log.debug("inserted: " + event.getObject());
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

package utils;

import java.util.LinkedList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.event.rule.ActivationCancelledEvent;
import org.drools.event.rule.ActivationCreatedEvent;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.AgendaGroupPoppedEvent;
import org.drools.event.rule.AgendaGroupPushedEvent;
import org.drools.event.rule.BeforeActivationFiredEvent;
import org.drools.event.rule.RuleFlowGroupActivatedEvent;
import org.drools.event.rule.RuleFlowGroupDeactivatedEvent;

public class AgendaListener implements AgendaEventListener{
	private LinkedList<String> firedRules = new LinkedList<String>();
	private static final Logger log = Logger.getLogger(AgendaListener.class);
	
	@Override
	public void activationCreated(ActivationCreatedEvent event) {
		log.info("activationCreated: " + event);
	}

	@Override
	public void activationCancelled(ActivationCancelledEvent event) {
		log.info("activationCancelled: " + event);
	}

	@Override
	public void beforeActivationFired(BeforeActivationFiredEvent event) {
		firedRules.add(event.getActivation().getRule().getName());
		log.info("beforeActivationFired: " + event);
	}

	@Override
	public void afterActivationFired(AfterActivationFiredEvent event) {
		log.info("afterActivationFired: " + event);
	}

	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		log.info("agendaGroupPopped: " + event);
	}

	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		log.info("agendaGroupPushed: " + event);
	}

	@Override
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		log.info("beforeRuleFlowGroupActivated: " + event);
	}

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		log.info("afterRuleFlowGroupActivated: " + event);
	}

	@Override
	public void beforeRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		log.info("beforeRuleFlowGroupDeactivated: " + event);
	}

	@Override
	public void afterRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		log.info("afterRuleFlowGroupDeactivated: " + event);
	}

	public LinkedList<String> getFiredRules() {
		return firedRules;
	}

	public void setFiredRules(LinkedList<String> firedRules) {
		this.firedRules = firedRules;
	}

}

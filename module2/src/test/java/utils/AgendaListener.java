package utils;

import java.util.LinkedList;

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
	
	@Override
	public void activationCreated(ActivationCreatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activationCancelled(ActivationCancelledEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeActivationFired(BeforeActivationFiredEvent event) {
		firedRules.add(event.getActivation().getRule().getName());
	}

	@Override
	public void afterActivationFired(AfterActivationFiredEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public LinkedList<String> getFiredRules() {
		return firedRules;
	}

	public void setFiredRules(LinkedList<String> firedRules) {
		this.firedRules = firedRules;
	}

}

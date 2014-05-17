package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class UserAction extends ActionFactBase implements ActionFact{
	private String description;
	
	public UserAction(Activity activity, String description) {
		super(activity);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

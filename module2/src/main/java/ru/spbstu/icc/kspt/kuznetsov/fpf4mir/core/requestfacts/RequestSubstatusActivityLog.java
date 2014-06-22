package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class RequestSubstatusActivityLog extends RequestSubstatusBase implements RequestSubstatus{
	private List<Activity> activities;

	public RequestSubstatusActivityLog(RequestFact request,
			List<Activity> activities) {
		super(request);
		this.activities = activities;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "RequestSubstatusActivityLog [activities=" + activities + "]";
	}

}

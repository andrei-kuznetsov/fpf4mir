package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.RequestRelatedFactBase;

public class ActivityBase extends RequestRelatedFactBase implements Activity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3159569789692737767L;

	public static final Activity USER = new GenericActivity().reset(R.id.UserActivity, new Date(), null);
	
	private static volatile long refIdCounter = 1;
	private String name;
	private Date date;
	private long refId = refIdCounter++;
	
	public Activity reset(String name, Date date, Request request) {
		super.reset(request);
		this.name = name;
		this.date = date;
		return this;
	}

	public Activity reset(Activity activity) {
		return this.reset(activity.getName(), activity.getDate(), activity.getRequest());
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() +  " [name=" + name + ", date=" + date
				+ ", request=" + getRequest() + "]";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getRefId() {
		return refId;
	}

	public void setRefId(long refId) {
		this.refId = refId;
	}

	public String toShortString() {
		return getClass().getSimpleName() +  " [id=" + name + "]";
	}
}

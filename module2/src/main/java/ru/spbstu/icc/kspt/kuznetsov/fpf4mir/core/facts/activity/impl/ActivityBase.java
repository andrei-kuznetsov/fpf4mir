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
	private String id;
	private Date date;
	private long refId = refIdCounter++;
	
	public Activity reset(String id, Date date, Request request) {
		super.reset(request);
		this.id = id;
		this.date = date;
		return this;
	}

	public Activity reset(Activity activity) {
		return this.reset(activity.getId(), activity.getDate(), activity.getRequest());
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() +  " [id=" + id + ", date=" + date
				+ ", request=" + getRequest() + "]";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return getClass().getSimpleName() +  " [id=" + id + "]";
	}
}

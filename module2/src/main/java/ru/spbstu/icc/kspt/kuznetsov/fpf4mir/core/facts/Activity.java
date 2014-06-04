package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.Serializable;
import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.GenericActivity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithRefId;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestRelatedFact;

public class Activity implements Serializable, FactWithRefId, RequestRelatedFact {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3159569789692737767L;

	public static final Activity USER = new GenericActivity().reset(R.id.UserActivity, new Date(), null);
	
	private static volatile long refIdCounter = 1;
	private String id;
	private Date date;
	private RequestFact request;
	private long refId = refIdCounter++;
	
	public Activity reset(String id, Date date, RequestFact request) {
		this.id = id;
		this.date = date;
		this.request = request;
		return this;
	}

	public Activity reset(Activity activity) {
		return this.reset(activity.id, activity.date, activity.request);
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() +  " [id=" + id + ", date=" + date
				+ ", request=" + request + "]";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RequestFact getRequest() {
		return request;
	}

	public void setRequest(RequestFact request) {
		this.request = request;
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
}

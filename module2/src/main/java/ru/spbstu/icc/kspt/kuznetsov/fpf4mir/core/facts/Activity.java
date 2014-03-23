package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class Activity {
	private String id;
	private int number;
	private Date date;
	private ReqNewActivity request;
	
	public Activity(String id, int number, Date date, ReqNewActivity request) {
		this.id = id;
		this.number = number;
		this.date = date;
		this.request = request;
	}

	public Activity(Activity activity) {
		this(activity.id, activity.number, activity.date, activity.request);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + number;
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Activity))
			return false;
		Activity other = (Activity) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number != other.number)
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		return true;
	}

	public int getNumber() {
		return number;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", number=" + number + ", date=" + date
				+ ", request=" + request + "]";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ReqNewActivity getRequest() {
		return request;
	}

	public void setRequest(ReqNewActivity request) {
		this.request = request;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.UserInfo;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class UserInfoBase<U> extends ActivityRelatedFactBase implements UserInfo<U>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3934320178442807427L;
	
	private String name;
	private U message;
	private Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public U getMessage() {
		return message;
	}
	public void setMessage(U message) {
		this.message = message;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserInfoBase<U> reset(Activity activity, U message){
		setActivity(activity);
		setMessage(message);
		return this;
	}
}

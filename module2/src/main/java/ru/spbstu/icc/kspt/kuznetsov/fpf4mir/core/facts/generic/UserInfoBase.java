package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.UserInfo;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

/**
 * @author qnf863
 *
 * @param <U>
 */
public class UserInfoBase<U> extends ActivityRelatedFactBase implements UserInfo<U>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3934320178442807427L;
	
	private String name;
	private U message;
	private Date date = new Date();
	
	protected UserInfoBase(String name) {
		this.name = name;
	}
	
	public UserInfoBase() {
	}
	
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
		super.reset(activity);
		this.message = message;
		return this;
	}

	public UserInfoBase<U> reset(Activity activity, String name, U message){
		super.reset(activity);
		this.message = message;
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", message=" + message
				+ ", activity=" + getActivity().toShortString() + "]";
	}
	
	
}

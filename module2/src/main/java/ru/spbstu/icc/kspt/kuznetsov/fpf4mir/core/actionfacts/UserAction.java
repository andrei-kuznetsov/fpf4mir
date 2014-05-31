package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;


public class UserAction extends ActionFactBase implements ActionFact{
	/**
	 * 
	 */
	private static final long serialVersionUID = -888602607972521791L;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

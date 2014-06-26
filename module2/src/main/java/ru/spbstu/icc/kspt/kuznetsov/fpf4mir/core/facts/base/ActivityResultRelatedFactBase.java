package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityResult;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityResultRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class ActivityResultRelatedFactBase implements ActivityResultRelatedFact, FPFCloneable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7009909694923412940L;
	
	private ActivityResult aresult;

	public ActivityResultRelatedFactBase() {
		super();
	}
	
	public ActivityResultRelatedFactBase(ActivityResult aresult) {
		super();
		this.aresult = aresult;
	}

	public ActivityResult getAresult() {
		return aresult;
	}

	public void setAresult(ActivityResult aresult) {
		this.aresult = aresult;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

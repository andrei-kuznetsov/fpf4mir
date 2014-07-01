package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.sources;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;

public class SrcEncoding extends ActivityRelatedFactBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5069318834266896174L;
	
	private String encoding;

	public SrcEncoding() {
	}
	
	public SrcEncoding(String srcEncoding) {
		this.encoding = srcEncoding;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String srcEncoding) {
		this.encoding = srcEncoding;
	}

	@Override
	public String toString() {
		return "SrcEncoding [srcEncoding=" + encoding + "]";
	}

	public SrcEncoding reset(Activity activity, String encoding){
		super.reset(activity);
		this.encoding = encoding;
		return this;
	}
}

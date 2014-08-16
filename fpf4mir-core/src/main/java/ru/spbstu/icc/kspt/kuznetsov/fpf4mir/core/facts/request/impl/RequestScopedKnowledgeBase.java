package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestScopedKnowledge;

public class RequestScopedKnowledgeBase extends ActivityRelatedFactBase implements RequestScopedKnowledge{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4931441234819422566L;

	protected RequestScopedKnowledgeBase() {
		super();
	}

	protected RequestScopedKnowledgeBase(Activity activity) {
		super(activity);
	}

}

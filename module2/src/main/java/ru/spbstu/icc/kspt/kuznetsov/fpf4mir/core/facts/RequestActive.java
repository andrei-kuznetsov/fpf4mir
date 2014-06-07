package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.RequestRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class RequestActive extends RequestRelatedFactBase{

	public RequestActive() {
		super();
	}

	public RequestActive(RequestFact request) {
		super(request);
	}

}

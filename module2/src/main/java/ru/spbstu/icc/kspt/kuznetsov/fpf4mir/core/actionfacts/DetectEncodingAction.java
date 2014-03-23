package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

public class DetectEncodingAction implements ActionFact {
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof DetectEncodingAction);
	}
	
	@Override
	public int hashCode() {
		return 346;
	}
}

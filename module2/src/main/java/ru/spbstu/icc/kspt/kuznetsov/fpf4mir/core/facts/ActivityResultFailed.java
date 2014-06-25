package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

public interface ActivityResultFailed extends ActivityResult {
	public String getMessage();
	public void setMessage(String message);
}

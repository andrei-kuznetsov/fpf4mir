package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import java.sql.SQLException;

public interface Dispatcher {
	public void preProcess(String submissionId, boolean force) throws SQLException;
}

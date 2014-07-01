package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.ExecCommand;

public final class GenericExecStatus extends ExecStatusBase implements ExecStatus {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5241046004264853033L;

	public GenericExecStatus(Activity activity, ExecCommand execCommand,
			int status, File fileOut, File fileErr) {
		super(activity, execCommand, status, fileOut, fileErr);
	}

}

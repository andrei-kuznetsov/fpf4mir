package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd;

import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public interface CmdLineArgument {
	public List<String> getArguments();
	public Activity getActivity();
}

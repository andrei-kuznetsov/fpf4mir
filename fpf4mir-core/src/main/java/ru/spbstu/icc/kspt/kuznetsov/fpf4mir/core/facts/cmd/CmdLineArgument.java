package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd;

import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;

public interface CmdLineArgument extends ActivityRelatedFact{
	public List<String> getArguments();
}

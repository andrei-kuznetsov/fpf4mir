package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.DataDirRoot;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir.ScratchDir;

public class DefaultScratchDir extends ScratchDir {

	public DefaultScratchDir(DataDirRoot dataDir) {
		super(null, dataDir);
	}
}

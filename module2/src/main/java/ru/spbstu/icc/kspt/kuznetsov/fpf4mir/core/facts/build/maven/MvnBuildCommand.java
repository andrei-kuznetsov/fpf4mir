package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildCommand;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ListExecCommand;

public class MvnBuildCommand extends ListExecCommand implements BuildCommand {
	private static final String COMMAND = "mvn";

	private class MvnOptionComparator implements Comparator<MvnOption>{

		@Override
		public int compare(MvnOption o1, MvnOption o2) {
			if (o1 instanceof OrdinalArgument){
				if (o2 instanceof OrdinalArgument){
					return ((OrdinalArgument) o1).compareTo((OrdinalArgument) o2);
				} else {
					return -1;
				}
			} else {
				if (o2 instanceof OrdinalArgument){
					return 1;
				} else {
					return 0;
				}
			}
		}
		
	}
	
	public MvnBuildCommand(Activity activity, File workingDir, List<MvnOption> options) {
		super(activity, COMMAND, workingDir);
		
		Collections.sort(options, new MvnOptionComparator());
		
		for (MvnOption i : options){
			getArgsList().addAll(i.getArguments());
		}

	}
}

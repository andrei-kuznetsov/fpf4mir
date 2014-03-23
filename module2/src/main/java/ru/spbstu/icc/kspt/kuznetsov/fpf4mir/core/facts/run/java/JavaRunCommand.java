package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunCommand;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.KeyValueArgument;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ListExecCommand;

public class JavaRunCommand extends ListExecCommand implements RunCommand {
	private static final String COMMAND = "java";

	public JavaRunCommand(Activity activity, File workingDir, List<JavaRunArgument> javaOptions, List<? extends KeyValueArgument> testOptions, List<? extends OrdinalArgument> testOrdinal) {
		super(activity, COMMAND, workingDir);
		
		Collections.sort(javaOptions, new Comparator<JavaRunArgument>() {
			@Override
			public int compare(JavaRunArgument o1, JavaRunArgument o2) {
				if (o1 instanceof JavaRunOption_Jar) return 1;
				else if (o2 instanceof JavaRunOption_Jar) return -1;
				else return 0;
			}
		});
		
		for (JavaRunArgument i : javaOptions){
			getArgsList().addAll(i.getArguments());
		}

		Collections.sort(testOrdinal);
		
		for (KeyValueArgument i : testOptions){
			getArgsList().addAll(i.getArguments());
		}
		
		for (OrdinalArgument i : testOrdinal){
			getArgsList().addAll(i.getArguments());
		}
	}

	@Override
	public String toString() {
		return "JavaRunCommand [toString()=" + super.toString() + "]";
	}
}

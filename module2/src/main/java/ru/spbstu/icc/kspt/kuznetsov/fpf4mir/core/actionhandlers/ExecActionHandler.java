package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecStatus;

public class ExecActionHandler implements ActionHandler{
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ActionHandler.class);

	@Override
	public void process(Action a, StatefulKnowledgeSession ksession) throws IOException, InterruptedException {
		ExecAction action = (ExecAction) a;
		final File workingDir = action.getWorkingDir();
		final File fileIn = new File(workingDir, UUID.randomUUID().toString() + ".in");
		final File fileOut = new File(workingDir, UUID.randomUUID().toString() + ".out");
		final File fileErr = new File(workingDir, UUID.randomUUID().toString() + ".err");
		
		final String command = action.getCommand();
        
        ProcessBuilder b = new ProcessBuilder(command);
        List<String> args = action.getArguments();
        args.add(0, command);
        
        System.out.println("Exec: " + Arrays.toString(args.toArray()));
        fileIn.createNewFile();
        
        b.command(args);
        b.redirectInput(fileIn);
        b.redirectOutput(fileOut);
        b.redirectError(fileErr);
        b.directory(workingDir);
        
        final Process p = b.start();
        final int returnCode = p.waitFor();

//        final BufferedReader is = new BufferedReader(new FileReader(fileOut));
//        String line;
//        while ((line = is.readLine()) != null) {
//            logger.warn(line);
//            System.out.println(line);
//        }
//        is.close();
//        
//        final BufferedReader is2 = new BufferedReader(new FileReader(fileErr));
//        while ((line = is2.readLine()) != null) {
//            logger.warn(line);
//            System.err.println(line);
//        }
//        is2.close();
        
        ksession.retract(ksession.getFactHandle(a));
    	ksession.insert(new GenericExecStatus(action.getActivity(), action.getExecCommand(), returnCode, fileOut, fileErr));
	}

}

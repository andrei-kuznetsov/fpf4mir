package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws Exception {
		log.setLevel(Level.ALL);

		
		
		if (args.length < 2){
			args = new String[] {
					"/home/andrei/OpenShift/datadir/cea1c11a-ff7b-4f6f-8974-d327f3ec544b/chordest-master.zip",
					"/media/andrei/WORK/phd/oma/test"};
			log.warn("Wrong invocation format");
			log.warn("Expected format is: 'main <originalArtifact> <dataset>'");
		}

		
		log.debug("Original artifact is '" + args[0] + "'");
		
		File oa = new File(args[0]);
		
		if (!oa.exists()){
			throw new RuntimeException("Original artifact: file '" + args[0] + "' doesn't exist!");
		}
		
		if (!(new File(args[1]).exists())){
			throw new RuntimeException("Dataset '" + args[1] + "' does not exist!");
		}
		
		DeploymentSession m = new DeploymentSession(/*oa, args[1]*/);
		m.init();
		m.assertFact(oa);
		m.run();
		
		log.info("Execution completed!");
	}

}

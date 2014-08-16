package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

public class KBRunner implements Runnable{
	
	private final DeploymentSession session;
	private volatile boolean running = false;
	
	public KBRunner(DeploymentSession session) {
		super();
		this.session = session;
	}

	@Override
	public void run() {
		try {
			running = true;
			session.run();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void runAsync(){
		Thread t = new Thread(this);
		t.start();
	}
	
	public void runSync(){
		run();
	}
	
	public boolean isRunning() {
		return running;
	}
}

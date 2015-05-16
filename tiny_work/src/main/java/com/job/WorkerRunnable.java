package com.job;

public class WorkerRunnable implements Runnable{
	
	private Worker worker;
	public WorkerRunnable(Worker worker){
		this.worker = worker;
	}
	public void run() {
		// TODO Auto-generated method stub
		worker.do_work();
	}

}

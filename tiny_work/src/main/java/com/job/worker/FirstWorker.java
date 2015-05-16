package com.job.worker;

import java.util.logging.Logger;

import com.job.Worker;

@com.annotation.Worker
public class FirstWorker implements Worker {

	private final static Logger logger = Logger.getLogger(FirstWorker.class.getName());
	
	public void do_work() {
		// TODO Auto-generated method stub
		logger.info("I am working!");
	}

	public void do_work(Object... args) {
		// TODO Auto-generated method stub
		
	}

}

package com.job.provider;

import com.job.Provider;
import com.job.WorkerRunnable;
import com.job.worker.FirstWorker;

public class WorkerProvider implements Provider<WorkerRunnable> {

	public WorkerRunnable produce() {
		// TODO Auto-generated method stub
		return new WorkerRunnable(new FirstWorker());
	}

}

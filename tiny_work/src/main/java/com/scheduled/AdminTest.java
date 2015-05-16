package com.scheduled;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import com.job.Provider;
import com.job.WorkerRunnable;
import com.job.provider.WorkerProvider;

public class AdminTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(4, new ThreadFactory() {
			
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				Thread thread = new Thread(r);
				thread.setName(r.getClass().getName());
				return thread;
			}
		});
		Provider provider = new WorkerProvider();
		WorkerRunnable runnable = (WorkerRunnable) provider.produce();
		pool.scheduleAtFixedRate(runnable, 1,10, TimeUnit.SECONDS);
	}
}

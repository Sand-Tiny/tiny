package com.driver.pool;

import java.sql.Connection;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.driver.DriverManager;

public class ConnectionPool{

	private ConcurrentLinkedQueue<Connection> linkedQueue = new ConcurrentLinkedQueue<Connection>();
	private DriverManager driver;
		
	
	public ConnectionPool(int poolSize,DriverManager driver) {
		this.driver = driver;
		for (int i = 0; i < poolSize; i++) {
			linkedQueue.add(driver.getConnection());
		}
	}



	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			while(linkedQueue.isEmpty()){
				Thread.sleep(500L);
			};
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		linkedQueue.add(driver.getConnection());
		return linkedQueue.poll();
	}

}

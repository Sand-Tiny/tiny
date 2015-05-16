package com.driver;

import java.sql.Connection;

public abstract class DriverManager {

	private ThreadLocal<Driver> driver = new ThreadLocal<Driver>();
	
	
	public Driver getDriver() {
		return driver.get();
	}



	public void setDriver(Driver driver) {
		this.driver.set(driver);
	}

	public abstract Connection getConnection();

}

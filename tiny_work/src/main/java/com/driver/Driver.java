package com.driver;

import java.sql.Connection;

public interface Driver {
	
	public String getDriverName();

	public void setDriverName(String driverName);

	public String getUrl();

	public void setUrl(String url);

	public String getUser();

	public void setUser(String user);

	public String getPassword();

	public void setPassword(String password);
	
	public Connection getConnection();
}

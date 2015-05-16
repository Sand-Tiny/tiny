package com.driver.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.driver.Driver;

public class OracleDriver implements Driver {
	
	private String driverName;
	private String url;
	private String user;
	private String password;

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("finally")
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
}

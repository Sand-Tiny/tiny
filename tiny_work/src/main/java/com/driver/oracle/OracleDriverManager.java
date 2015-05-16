package com.driver.oracle;

import java.sql.Connection;

import com.driver.DriverManager;

public class OracleDriverManager extends DriverManager {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return getDriver().getConnection();
	}

}

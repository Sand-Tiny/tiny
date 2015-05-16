package com.driver.mysql;

import java.sql.Connection;

import com.driver.DriverManager;

public class MysqlDriverManager extends DriverManager {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return getDriver().getConnection();
	}
}

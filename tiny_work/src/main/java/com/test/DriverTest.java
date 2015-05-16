package com.test;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.dao.SimpleDao;
import com.driver.Driver;
import com.driver.DriverManager;
import com.driver.mysql.MysqlDriver;
import com.driver.mysql.MysqlDriverManager;
import com.driver.pool.ConnectionPool;

public class DriverTest {
	
	private final static Logger logger = Logger.getLogger(DriverTest.class.getName());
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	
	public static void main(String args[]) throws Exception {
		Driver driver = new MysqlDriver();
		driver.setDriverName(DRIVER);
		driver.setUrl(URL);
		driver.setUser(USER);
		driver.setPassword(PASSWORD);
		DriverManager manager = new MysqlDriverManager();
		manager.setDriver(driver);
		ConnectionPool pool = new ConnectionPool(10,manager);
		SimpleDao dao = new SimpleDao(pool.getConnection());
		String sql = "SELECT * FROM acquisitionsystem.tb_sensor where tmp = ?";
		List<Map<String, Object>> list = dao.query(sql, new Object[]{29});
		for (int i = 0; i < list.size(); i ++) {
			logger.info(list.get(i).toString());
		}
	}
}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDao {

	private Connection connection;
	public SimpleDao(Connection connection){
			this.connection = connection;
	}
	
	public List<Map<String, Object>> query(String sql) throws Exception{
		return this.query(sql,null);
	}
	
	public List<Map<String, Object>> query(String sql, Object[] args) throws Exception{
		PreparedStatement statement = this.connection.prepareStatement(sql);
		for (int i = 0; null != args && i < args.length; i ++) {
			statement.setObject(i + 1, args[i]);
		}
		ResultSet resultSet = statement.executeQuery();
		if (null == resultSet) 
			return null;
		ResultSetMetaData metaData = resultSet.getMetaData();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>(resultSet.getRow());
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < metaData.getColumnCount(); i ++) {
				map.put(metaData.getColumnLabel(i + 1), resultSet.getObject(i + 1));
			}
			list.add(map);
		}
		return list;
	}
	
	public int update(String sql) throws Exception{
		PreparedStatement statement = this.connection.prepareStatement(sql);
		return statement.executeUpdate();
	}
	
	public int update(String sql, Object[] args) throws Exception {
		PreparedStatement statement = this.connection.prepareStatement(sql);
		for (int i = 0; i < args.length; i ++) {
			statement.setObject(i + 1, args[i]);
		}
		return statement.executeUpdate();
	}
	
	public int[] updateBatch(String sql, List<Object[]> args) throws Exception {
		PreparedStatement statement = this.connection.prepareStatement(sql);
		for (int i = 0; null != args && i < args.size(); i ++){
			Object[] arg = args.get(i);
			if (null == args) continue;
			for (int j = 0; j < arg.length; j ++) {
				statement.setObject(j + 1, arg[j]);
			}
		}
		return statement.executeBatch();
	}
}

package com.assignment.weather.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import com.assignments.utils.Constants;

/**
 * @author vijay.kumbhakarna
 *
 */
public class DBConnection {
	
	public Connection makeConnection() throws Exception{
		Connection conn = null;
		
		Class.forName(Constants.getInstance().getDriverClassName());
		conn = DriverManager.getConnection(Constants.getInstance().getUrl(),Constants.getInstance().getUserName(),Constants.getInstance().getPassword());
		
		return conn;
	}
}

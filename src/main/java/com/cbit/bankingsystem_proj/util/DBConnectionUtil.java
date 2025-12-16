package com.cbit.bankingsystem_proj.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnectionUtil {

	private static Connection con = null;
	private DBConnectionUtil() {}
	
	public static Connection createOracleConnection() {
		try {
			InputStream fis = DBConnectionUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");//src/main/resources
			Properties prop = new Properties();
			prop.load(fis);
			
			Class.forName(prop.getProperty("jdbc.driverclass"));
			if(con==null) {
				synchronized (DBConnectionUtil.class) {
					if(con==null) {
					  con = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"), prop.getProperty("jdbc.password"));
					}	
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}

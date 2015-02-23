package com.icss.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 数据库操作类
 * @author J.L.Zhou
 *
 */
public class DBUtil {
	
	private static String name,pwd,url;
	static {
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("conn.properties"));
			Class.forName(p.getProperty("driver"));
			name = p.getProperty("name");
			pwd = p.getProperty("pwd");
			url = p.getProperty("url");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(url,name,pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
}

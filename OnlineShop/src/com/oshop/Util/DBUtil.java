package com.oshop.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
//	public static String URL = "jdbc:mysql://localhost:3306/onlineshop?serverTimezone=Asia/Shanghai";
//	public static String USER = "root";
//	public static String PASSWORD = "201266";
	private static String DRIVER_CLASS = null;	//数据库驱动
	private static String URL = null;		//数据库链接地址
	private static String USER = null;		//数据库用户名称
	private static String PASSWORD = null;	//数据库密码
	public Connection conn = null;
	static {
		try {
			// 创建Properties类对象
			Properties properties = new Properties();
			//读取db.proprtties文件到输入流中
			InputStream ins = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");
			//从输入流中加载属性列表
			properties.load(ins);
			
			DRIVER_CLASS = properties.getProperty("DRIVER_CLASS");
			URL = properties.getProperty("DB_URL");
			USER = properties.getProperty("DB_USER");
			PASSWORD = properties.getProperty("DB_PASSWORD");
			
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Connection Succeed.");
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection Error.");
		}
		return conn;
	}
	
	public void closeConnection() {
		if(conn!=null)
			try {
				conn.close();
				System.out.println("Connection Closed.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) throws Exception {
		/*
		//1. Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. Get Connection
		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		//3. Create Statement
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT name, price FROM goods");
		while(rs.next()) {
			System.out.println(rs.getString("name")+" ￥"+rs.getDouble("price"));
		}
		rs.close();
		stmt.close();
		conn.close();
		*/
		DBUtil dbutil = new DBUtil();
		dbutil.getConnection();
		}
}

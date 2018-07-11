package com.caorunjia.BMS.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil{
	private static final String URL="jdbc:mysql://127.0.0.1:3306/books?characterEncoding=UTF-8";
	private static final String USER="root";
	private static final String PASSWORD="";
	private static Connection conn=null;
	static
	{
		try {
			//1.加载数据库
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库连接
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return conn;
	}
}
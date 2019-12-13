package com.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
private static Connection connection;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/advance_java";
		String user="root";
		String pass="1235";
		
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection(url,user,pass);
		
		return connection;
		
	}
}

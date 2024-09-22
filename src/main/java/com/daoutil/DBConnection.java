package com.daoutil;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;


public class DBConnection {

	private static Connection con=null;
	public static Connection getconnection()  {
		try {
			System.out.println("connection invoked");
			Class.forName("com.mysql.cj.jdbc.Driver");
	     	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
		}
		catch(ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}

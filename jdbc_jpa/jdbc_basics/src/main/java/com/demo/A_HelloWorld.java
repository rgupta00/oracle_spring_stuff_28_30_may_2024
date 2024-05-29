package com.demo;
import java.sql.*;
public class A_HelloWorld {
	
	public static void main(String[] args) {
		//load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver is loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection connection=null;
		//Connection object
		try {
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/edu123","root","root");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from account");
			
			while(rs.next()) {
				System.out.println(rs.getInt("id")+": "+rs.getString("name")+": "+ rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}












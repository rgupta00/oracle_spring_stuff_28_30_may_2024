package com.demo;
import java.sql.*;
public class B_HelloWorldWithConnFactory {
	
	public static void main(String[] args) {
		
		Connection connection=null;
	
		try {
			 connection=ConnectionFactory.getConnection();
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












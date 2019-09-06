package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	
	public Connection getConnection() throws ClassNotFoundException, Exception{
		try{
		Class.forName(DbDetails.DRIVER);
		}
		catch(ClassNotFoundException ae){
			System.out.println("error while loading the class");
		}
		System.out.println("class loaded");
		try{
		Connection conn = DriverManager.getConnection(DbDetails.URL,DbDetails.USERNAME,DbDetails.PASSWORD);
		 return conn;
		} catch(Exception ex){
			System.out.println("Ërror in connection");
			ex.printStackTrace();
			  return null;
		}
		
	}
}

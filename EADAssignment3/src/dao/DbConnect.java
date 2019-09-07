package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class DbConnect {
	  public static Connection conn;
	 public Connection getConnection() throws Exception{
		 try{
			 String url = "jdbc:mysql://localhost:3306/student";	
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("class loaded");
			 conn =  DriverManager.getConnection(url,"root","root");
			 System.out.println("connection established");
			 return conn;
		 }
		 catch(Exception ex){
				System.out.println("Ërror in connection");
				ex.printStackTrace();
				  return null;
			}
		 
	 }
	 public static void main(String[] args) throws Exception {
		
		 new DbConnect().getConnection();
	}
}
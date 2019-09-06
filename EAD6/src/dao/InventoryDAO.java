package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import services.Inventory;
import util.DatabaseConnection;
import util.Queries;
import enums.Status;

public class InventoryDAO {
	
	public Status insertInventory(String name,Integer quantity) throws ClassNotFoundException, Exception{
		Connection connect;
		 DatabaseConnection conn = new DatabaseConnection();
		 connect=conn.getConnection();
		 PreparedStatement stmt = connect.prepareStatement(Queries.INSERTINVENTORY);
		 stmt.setString(1,name);
		 stmt.setInt(2, quantity);
		 if(stmt.executeUpdate() >0){
			 return Status.INSERTED;
		 }
		return Status.FAILED;
		
	}
	
	public List<Inventory> getAllInventory() throws ClassNotFoundException, Exception{
		Connection connect;
		DatabaseConnection conn = new DatabaseConnection();
		connect = conn.getConnection();
		Statement stmt = connect.createStatement();// used prepared to set String
		ResultSet rs = stmt.executeQuery(Queries.GETALLINVENTORY);
		List<Inventory> list = new ArrayList<Inventory>();
		while(rs.next()){
				Inventory inventory = new Inventory();
				inventory.setName(rs.getString(1));
				inventory.setQuantity(rs.getInt(2));
				list.add(inventory);
		}
		return list;
		
	}
	
	public  Inventory getInventoryByName(String name) throws ClassNotFoundException, Exception{
		Connection connect;
		DatabaseConnection connection = new DatabaseConnection();
		connect = connection.getConnection();
		PreparedStatement stmt = connect.prepareStatement(Queries.GETINVENTORYBYNAME);
        stmt.setString(1,name);
        ResultSet rs = stmt.executeQuery();
        Inventory inventory = new Inventory();
        if(rs.next()){
			inventory.setName(rs.getString(1));
			inventory.setQuantity(rs.getInt(2));
		}
		return inventory;
		
		
	}
	
	public Status updateInventory(String name,Integer quantity) throws ClassNotFoundException, Exception{
		Connection connect;
		DatabaseConnection connection = new DatabaseConnection();
		connect=connection.getConnection();
		PreparedStatement stmt = connect.prepareStatement(Queries.UPDATEINVENTORY);
		stmt.setString(2, name);
		stmt.setInt(1, quantity);
		if(stmt.executeUpdate() > 0){
			return Status.UPDATED;
		}
		
		return Status.FAILED;
		
	}
	public Status deleteInventory(String name) throws ClassNotFoundException, Exception{
			Connection connect;
			DatabaseConnection connection = new DatabaseConnection();
			connect = connection.getConnection();
			PreparedStatement stmt = connect.prepareStatement(Queries.DELETEINVENTORY);
			stmt.setString(1,name);
			if( stmt.executeUpdate() >0){
				return Status.DELETED;
				}
		return Status.FAILED;
	}
	
	public Status deleteall()throws Exception{
		Connection connect;
		DatabaseConnection connection = new DatabaseConnection();
		connect=connection.getConnection();
		PreparedStatement stmt = connect.prepareStatement(Queries.DELETEALL);
		return Status.DELETED;
	}
	


}

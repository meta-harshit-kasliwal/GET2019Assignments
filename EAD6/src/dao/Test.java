package dao;

import java.util.List;

import services.Inventory;
import util.DatabaseConnection;

public class Test {
public static void main(String[] args) {
	
	InventoryDAO Dao = new InventoryDAO();
	try {
		Dao.insertInventory("Apple", 50);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	/*try {
		Dao.deleteInventory("Apple");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	
	
	
	/*try {
		//List<Inventory>list = Dao.getAllInventory();
	Inventory i = Dao.getInventoryByName("Orange");
	 System.out.println(i.getName()+i.getQuantity());
	}
	catch(Exception e){
		e.printStackTrace();
	}*/
		/*for(Inventory in : list){
			System.out.println(in.getName()+in.getQuantity());
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	
}
}

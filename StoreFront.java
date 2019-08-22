package assignment5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class StoreFront {

	public static Connection conn;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront", "root", "root");
		}catch(Exception ex){
			System.out.println("Ërror in connection");
			System.exit(0);
		}
		shippedOrderofUser(1);
		 List<String> images=new ArrayList<>();
		 images.add("image1.jpg");
		 images.add("image2.jpg");
		 images.add("image3.jpg");
		 images.add("image4.jpg");
		 images.add("image5.jpg");
		// insertImageofProduct(1, images);
		// removeProduct();
		 showCategoryDetail();
		 conn.close();
		
		
	}
	
	 public static void shippedOrderofUser(int userId) {
	    	String query = "select o.id,o.date_of_order_placed,o.amount from orders o join item_list i on o.id=i.order_number where  o.user_id=? and i.status = 'SHIPPED' order by o.date_of_order_placed";
	        try {
	             PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setInt(1, userId);
	            ResultSet rs = stmt.executeQuery();
	            List<Orders> listOfOrders = new ArrayList<>();

	            while (rs.next()) {
	                listOfOrders.add(new Orders(rs.getInt("id"),
	                				rs.getString("date_of_order_placed"), 
	                				rs.getInt("amount")));
	                               }
	           for (Orders order : listOfOrders) {
	                System.out.println(order.getOrder_id() + "\t" + order.getDate()
	                        + "\t" + order.getAmount());
	            }
	         
	        } catch (SQLException ex) {
	            System.out.println("Error Occur");
	        }

	    }
	 
	 public static void insertImageofProduct(int productId, List<String> image) {
	        String query = "insert into image(product_id,image) values(?,?)";
	        try {
	            PreparedStatement stmt = conn.prepareStatement(query);
	            conn.setAutoCommit(false);
   
            for (int count = 0; count <= image.size()-1; count++) {
	                stmt.setInt(1, productId);
	                stmt.setString(2, image.get(count));
	                stmt.addBatch();
	            }

	            int[] res = stmt.executeBatch();
	            System.out.println("Images inserted:" + res.length);
	            conn.commit();
	           
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }

	    }
	 
	  public static void removeProduct() {
	    	 String query = "update product set active=0 WHERE id NOT IN(SELECT i.product_id FROM item_list i join orders o where"
	                 + " o.id=i.order_number AND DATEDIFF(CURDATE(),o.date_of_order_placed)<365)";
	       
	        try {
	             PreparedStatement stmt = conn.prepareStatement(query);
	              System.out.println("Total removed Product:"+stmt.executeUpdate());

	        } catch (SQLException ex) {
	            System.out.println("Ërror occur");
	        }
	        
	    }
	  
	    public static void showCategoryDetail(){
	        String query="select p.category_name,count(c.parent_id) from category p left join category c on p.id = c.parent_id group by p.id";
	        try {
	            
	            PreparedStatement stmt = conn.prepareStatement(query);
	            ResultSet rs = stmt.executeQuery();
	            List<Category> parentList=new ArrayList<>();
	            while (rs.next()) {
	                parentList.add(new Category(rs.getString(1),rs.getInt(2)));
	            }
	            System.out.println("Category"+"\t"+"Total Child");
	            for(Category category:parentList){
	                System.out.println(category.getParent_category()+"\t\t\t"+category.getChild_category());
	            }
	        } catch (SQLException ex) {
	            System.out.println("Error Occur");
	        }
	    }
	    

}

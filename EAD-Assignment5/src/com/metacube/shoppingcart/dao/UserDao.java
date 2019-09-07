package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entities.Product;
import com.metacube.shoppingcart.entities.User;

public class UserDao {

	static UserDao userDao=null;
	User user;
	
	public UserDao(){
		user = new User();
	}
		
	public static UserDao getInstance(){
		if(userDao==null){
			userDao = new UserDao();
		}
		return userDao;
	}

	public User createUser(String name){
		user.setUserName(name);
		return user;
	}
	
	public void showShoppingCart(){
		for(Product product : this.user.getCart().getUserProducts()){
			System.out.println(product.getProductName()+" "+product.getQuantity()+" "+product.getProductPrice());
		}
	}
}

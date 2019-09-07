package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entities.Product;

public class ShoppingCartDao {
	
	UserDao userDao;
	static ShoppingCartDao cartDao=null;
	
	public ShoppingCartDao(){
		userDao = UserDao.getInstance();
	}
	
	public static ShoppingCartDao getInstance(){
		if(cartDao==null){
			cartDao = new ShoppingCartDao();
		}
		return cartDao;
	}

	
	public void addproduct(Product product){
		userDao.user.getCart().getUserProducts().add(product);
	}
	
	public void removeproduct(Product product){
		userDao.user.getCart().getUserProducts().remove(product);
	}

}

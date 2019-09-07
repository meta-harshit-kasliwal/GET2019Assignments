package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dao.UserDao;
import com.metacube.shoppingcart.entities.User;

public class UserFacade {
	
	UserDao userDao;
	static UserFacade userFacade=null;
	
	public UserFacade(){
		userDao = UserDao.getInstance();
	}
	
	public static UserFacade getInstance(){
		if(userFacade==null){
			userFacade = new UserFacade();
		}
		return userFacade;
	}
	
	public User createUser(String name){
		return this.userDao.createUser(name);
	}

	public void showShoppingCart(){
		this.userDao.showShoppingCart();
	}
}

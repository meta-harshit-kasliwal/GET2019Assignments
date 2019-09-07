package com.metacube.shoppingcart.entities;

import java.util.List;

public class User {
	
	String userName;
	ShoppingCart cart;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	
	
	
}

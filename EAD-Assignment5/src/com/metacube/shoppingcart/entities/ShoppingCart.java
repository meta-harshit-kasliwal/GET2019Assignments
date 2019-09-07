package com.metacube.shoppingcart.entities;

import java.util.List;

public class ShoppingCart {
	
	List<Product> userProducts;
	Double total=(double)0;

	public List<Product> getUserProducts() {
		return userProducts;
	}

	public void setUserProducts(List<Product> userProducts) {
		this.userProducts = userProducts;
	}
	
	public double getTotal(){
		
		for(Product product:userProducts){
			total = total + product.getProductPrice();
		}
		return total;
		
	}
	
	

}

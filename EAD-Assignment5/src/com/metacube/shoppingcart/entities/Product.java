package com.metacube.shoppingcart.entities;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	Integer productId;
	String productName;
	Double productPrice;
	Integer quantity;
	
	public Product(Integer productId, String productName, Double productPrice,Integer quantity) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return  productId + "\t"
				+ productName + "\t\t" + productPrice
				+ "\t" + quantity ;
	}
	
	
}

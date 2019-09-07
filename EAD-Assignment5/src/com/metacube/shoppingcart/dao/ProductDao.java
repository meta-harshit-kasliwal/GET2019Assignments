package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.entities.Product;

public class ProductDao {
	
	List<Product> productList;
	static ProductDao productDao=null;
	
	public ProductDao(){
		productList = new ArrayList<Product>();
		this.productList.add(new Product(1,"Shirt",(double)250,10));
		this.productList.add(new Product(2,"Jeans",(double)550,20));
		this.productList.add(new Product(3,"Mobile",(double)6000,8));
		this.productList.add(new Product(4,"Watch",(double)880,14));
	}
	
	public static ProductDao getInstance(){
		if(productDao==null){
			productDao = new ProductDao();
		}
		return productDao;
	}
	
	public List<Product> getallProdcuts(){
		return productList;
	}

}

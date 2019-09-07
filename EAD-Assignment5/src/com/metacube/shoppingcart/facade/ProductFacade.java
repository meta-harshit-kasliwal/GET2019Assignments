package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.ProductDao;
import com.metacube.shoppingcart.entities.Product;

public class ProductFacade {
	
	static ProductFacade productFacade=null;
	ProductDao productDao;
	
	public ProductFacade(){
		this.productDao = ProductDao.getInstance();
	}
	
	public static ProductFacade getInstance(){
		if(productFacade == null){
			productFacade = new ProductFacade();
		}
		return productFacade;
	}
	
	public List<Product> getallProducts(){
		return this.productDao.getallProdcuts();
	}

}

package com.metacube.shoppingcart.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingcart.entities.Product;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;

public class View {

	public static void main(String[] args) {
		
		UserFacade userFacade = UserFacade.getInstance();
		ProductFacade productFacade = ProductFacade.getInstance();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your Name:");
		String name = input.nextLine();
		userFacade.createUser(name);
		Integer choice=null;
		while(true){
			showChoice();
			choice=input.nextInt();
			if(choice==1){
				List<Product> listProduct= (ArrayList<Product>) productFacade.getallProducts();
				System.out.println("Id"+"\t"+"Product Name"+"\t"+"Price"+"\t"+"Quantity");
				for(Product product : listProduct){
					System.out.println(product);
				}
			}
			else
				System.exit(1);
		}
		
	}
	public static void showChoice(){
		System.out.println("1. Add Products");
		System.out.println("2. Show Cart");
		System.out.println("Press any key to exit");
	}

}

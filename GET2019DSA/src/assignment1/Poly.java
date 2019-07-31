package assignment1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
* Author: Harshit Kasliwal
* Since: July. 30, 2019
* Name: Poly
* Description: This class used to calculate power of a multi - variable poly.
**/
public class Poly {
	 /**
	* Name: degree
	* Disc: to  calculate power of a multi - variable poly. 
	* @param: (1) lists- list of list of integers - stores power of variables given by user.  
	* @return: integer - power of poly
	**/
	public int degree( List<List<Integer>> lists ){
		int sum = 0;
		int max = 0;
	    int i = 0;
	    while(i < lists.size()){
	    	  sum = 0;
	    	  for(int j = 0;j< lists.get(i).size(); j++){
	    		  sum = sum + lists.get(i).get(j);
	    	  }
	    	  
	    	  if(sum >= max){
	    		  max = sum;
	    	  }
	    	i++;
	    }
		return max;
	}
public static void main(String[] args) {
	
	  int i = 0;

	  Scanner obj = new Scanner(System.in);

	  List<List<Integer>> lists = new ArrayList<List<Integer>>();
	 
	  System.out.println("Enter the number of terms");
	 
	  int n = obj.nextInt();

	  	 System.out.println("Enter the number of variables in poly"); 
	  	 int d = obj.nextInt();
	  while(i<n){
		  List<Integer> list = new ArrayList<Integer>();
		  	
		  	for(int j=0;j<d;j++){
			  System.out.println("enter power of variable "+(j+1)+" in term "+(i+1));
			  list.add(obj.nextInt());
	    }
	    lists.add(list); 
	    System.out.println("List "+i+ " is created ");
	    System.out.println(lists.get(i));
	    System.out.println("");
	    i++;
	  } 
	  System.out.println("out of the loop");
	 int ans = new Poly().degree(lists);
	 System.out.println("power is "+ ans);
     
    }
    
	 
	 
	}
	

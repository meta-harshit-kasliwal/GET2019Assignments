package assignment1;


/**
* Author: Harshit Kasliwal
* Since: July. 29, 2019
* Name: LinkedListImplementation
* Description: This class have basic code to call functions and display result  
**/
public class LinkedListImplementation{
	
	public static void main(String[] args) {
		
		LinkedList obj=new LinkedList();
		Node first = obj.insert(10);
		Node second = obj.insert(20);
		Node third = obj.insert(30);
		Node fourth = obj.insert(40);
		Node fifth = obj.insert(50);
		Node sixth = obj.insert(60); 
		
		sixth.next=third;
		obj.display();
		
		System.out.println(obj.containsLoop());
	}

}


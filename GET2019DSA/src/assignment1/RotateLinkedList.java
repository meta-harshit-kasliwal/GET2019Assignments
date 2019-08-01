package assignment1;

import java.util.Scanner;

/**
* Author: Harshit Kasliwal
* Since: July. 29, 2019
* Name: RotateLinkedList
* Description: This class have basic code to call functions and display result  
**/
public class RotateLinkedList {
     public static void main(String[] args) {
    	 Scanner sc= new Scanner(System.in);
	     LinkedList obj =new LinkedList();
	     obj.insert(10);
	     obj.insert(20);
	     obj.insert(30);
	     obj.insert(40);
	     obj.insert(50);
	     obj.insert(60);
	     obj.insert(70);
	     System.out.println("linked list before rotation :");
	     obj.display();
	     System.out.println("enter no of time you want to rotate the list :(clockwise)");
	     int no=sc.nextInt();
	    String ans= obj.rotate(obj.head,2,5,2);
	    System.out.println(ans);;
	     
	}
}

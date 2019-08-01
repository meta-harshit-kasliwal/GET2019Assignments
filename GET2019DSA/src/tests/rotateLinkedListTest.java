package tests;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import assignment1.LinkedList;
import assignment1.Node;

/**
* Author: Harshit Kasliwal
* Since: July. 30, 2019
* Name: RotateLinkedListTest
* Description: This class have basic code to call functions and display result  
**/
public class rotateLinkedListTest {
	

	    /**
		* Name: rotateTestPositive
		* Disc: consists of positive test cases for function rotate of class LinkedList.
		**/
	@Test
	public void rotateTestPositive(){
		LinkedList obj = new LinkedList();
		Node first = obj.insert(10);
		Node second = obj.insert(20);
		Node third = obj.insert(30);
		Node fourth = obj.insert(40);
		Node fifth = obj.insert(50);
		Node sixth = obj.insert(60); 
		Node seven = obj.insert(70);
		Assert.assertEquals("10405020306070", obj.rotate(obj.head,2,5,2));
	}

	   /**
		* Name: degreeTestPositive
		* Disc: consists of negetive test cases for function rotate of class LinkedList.
		**/
	@Test
	public void rotateTestNegetive(){
		LinkedList obj = new LinkedList();
		Node first = obj.insert(10);
		Node second = obj.insert(20);
		Node third = obj.insert(30);
		Node fourth = obj.insert(40);
		Node fifth = obj.insert(50);
		Node sixth = obj.insert(60); 
		Node seven = obj.insert(70);
		Assert.assertNotEquals(" 10405020306070 ", obj.rotate(obj.head,2,5,2));
	}


}

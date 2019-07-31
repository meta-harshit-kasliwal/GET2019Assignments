package tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import assignment1.LinkedList;
import assignment1.Node;


public class LinkedListTest {
	
	
		@Test
		public void containsLoopPositive(){
			LinkedList obj=new LinkedList();
			Node first = obj.insert(10);
			Node second = obj.insert(20);
			Node third = obj.insert(30);
			Node fourth = obj.insert(40);
			Node fifth = obj.insert(50);
			Node sixth = obj.insert(60); 
			
			sixth.next=third;
			Assert.assertEquals(true,obj.containsLoop());
		}
		@Test
		public void containsLoopNegetive(){
			LinkedList obj=new LinkedList();
			Node first = obj.insert(10);
			Node second = obj.insert(20);
			Node third = obj.insert(30);
			Node fourth = obj.insert(40);
			Node fifth = obj.insert(50);
			Node sixth = obj.insert(60); 
			Assert.assertNotEquals(true,obj.containsLoop());
		}
		
	}




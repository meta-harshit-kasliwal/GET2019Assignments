package tests;
import static java.util.Arrays.*;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import assignment1.Poly;

/**
* Author: Harshit Kasliwal
* Since: July. 30, 2019
* Name: PolyTest
* Description: This class used to test Poly which is used to calculate power of a multi - variable poly.
**/
public class PolyTest {
	
	 /**
		* Name: degreeTestPositive
		* Disc: consists of positive test cases for function degree of class Poly.
		**/
	@Test
	public void degreeTestPositive(){
		List<List<Integer>> lists = asList(
                asList(1,2,3),
                asList(4,5,6),
                asList(7,8,9)
              );
		Assert.assertEquals(24, new Poly().degree(lists));
	}

	 /**
		* Name: degreeTestNegetive
		* Disc: consists of negetive test cases for function degree of class Poly.
		**/
	@Test
	public void degreeTestNegetive(){
		List<List<Integer>> lists = asList(
                asList(1,2,3),
                asList(4,5,6),
                asList(7,8,9)
              );
		
		Assert.assertNotEquals(23, new Poly().degree(lists));
	}


}


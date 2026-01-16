package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sysImplementation.Utilities;

public class StudentTests{
	//filter tests
	@Test
	public void testFilter01() {
		System.out.println("Testing filter(normal): ");
		int [] test1 = {1, 2, 3, 4, 5, 6, 7};
		int lower = 3;
		int upper = 5;
		int [] result = Utilities.filter(test1, lower, upper);
		int [] answer = {3, 4, 5};
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
			assertEquals(answer[i], result[i]);
		}
	}
	@Test
	public void testFilter02() {
		System.out.println("Testing filter(upperLimit < lowerLimit): ");
		int [] test2 = {1, 2, 3, 4, 5, 6, 7};
		int lower = 5;
		int upper = 3;
		try {
	        Utilities.filter(test2, lower, upper);
	        // If no exception is thrown, fail the test
	        fail("Expected IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	        // Check that the message matches the expected one
	        assertEquals("upperLimit < lowerLimit" , e.getMessage());
	        System.out.println("upperLimit < lowerLimit");
	    }
	}
	@Test
	public void testFilter03() {
		System.out.println("Testing filter(null): ");
		int [] test3 = null;
		int lower = 3;
		int upper = 7;
		try {
	        Utilities.filter(test3, lower, upper);
	        // If no exception is thrown, fail the test
	        fail("Expected IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	        // Check that the message matches the expected one
	        assertEquals("Null Array" , e.getMessage());
	        System.out.println("Null Array");
	    }
	}
	
	//getArrayString tests
	@Test
	public void testGetArrayString01() {
		System.out.println("Testing getArrayString(normal): ");
		int [] test1 = {1, 2, 3, 4, 5};
		char separator = '*';
		String answer = "1*2*3*4*5";
	    String result = Utilities.getArrayString​(test1, separator);
	    System.out.println("Answer: " + answer + ", result: " + result);
	    assertEquals(answer, result);
	}
	@Test
	public void testGetArrayString02() {
		System.out.println("Testing getArrayString(Empty Array): ");
		int [] test2 = {};
		char separator = '*';
		String answer = "";
	    String result = Utilities.getArrayString​(test2, separator);
	    System.out.println("Answer: " + answer + ", result: " + result); 
	    assertEquals(answer, result);
	}
	@Test
	public void testGetArrayString03() {
		System.out.println("Testing getArrayString: ");
		int [] test3 = null;
		char separator = '*';
		try {
		    Utilities.getArrayString​(test3, separator);
		    fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
	    	assertEquals("Null Array", e.getMessage());
		}
	}
	
	//getArrayStringsLongerThan tests
	@Test
	public void testGetArrayStringsLongerThan01() {
		System.out.println("Testing getArrayStringsLongerThan(normal): ");
		StringBuffer [] sbArray = {
			    new StringBuffer("Hello"),
			    new StringBuffer("hi"),
			    new StringBuffer("world"),
			    new StringBuffer("swimming"),
			    new StringBuffer("fly")
			};
		int length = 4;
		StringBuffer [] result = 
				Utilities.getArrayStringsLongerThan​(sbArray, length);
		StringBuffer [] anwser = {
				new StringBuffer("Hello"),
				new StringBuffer("world"),
				new StringBuffer("swimming")
		};
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
			assertEquals(anwser[i].toString(), result[i].toString());
		}
	}
	@Test
	public void testGetArrayStringsLongerThan02() {
		System.out.println("Testing getArrayStringsLongerThan(length 0): ");
		StringBuffer [] sbArray = new StringBuffer[0];
		int length = 4;
		StringBuffer [] result = 
				Utilities.getArrayStringsLongerThan​(sbArray, length);
		StringBuffer [] anwser = new StringBuffer[0];
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
			assertEquals(anwser[i].toString(), result[i].toString());
		}
	}
	@Test
	public void testGetArrayStringsLongerThan03() {
		System.out.println("Testing getArrayStringsLongerThan(null): ");
		StringBuffer [] sbArray = null;
		int length = 4;
		try {
			Utilities.getArrayStringsLongerThan​(sbArray, length);
		    fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException e){
			assertEquals("Null Array", e.getMessage());
		}
		
	}
	//getInstance tests
	@Test
	public void testGetInstance01() {
		System.out.println("Testing getInstance(normal): ");
		int [] test1 = {1, 11, 111, 1111, 11111};
		int upper = 20;
		int lower = 0;
		int result = Utilities.getInstances​(test1, lower, upper);
		int answer = 2;
		assertEquals(result, answer);
	}
	@Test
	public void testGetInstance02() {
		System.out.println("Testing getInstance(null): ");
		int [] test1 = null;
		int upper = 20;
		int lower = 0;
		try {
			Utilities.getInstances​(test1, lower, upper);
		} catch (IllegalArgumentException e) {
			assertEquals("Null Array", e.getMessage());
		}
	}
	//rotate tests
	@Test
	public void testRotate01() {
		System.out.println("Testing Rotate(Left once): ");
		int [] test1 = {1, 2, 3, 4, 5};
		boolean leftRotate = true;
		int positions = 1;
		Utilities.rotate(test1, leftRotate, positions);
		int [] answer = {2, 3, 4, 5, 1};
		for(int i = 0; i < test1.length; i++) {
			System.out.print(test1[i] + " ");
			assertEquals(answer[i], test1[i]);
		}
	}
	@Test
	public void testRotate02() {
		System.out.println("\nTesting Rotate(Left multiple times): ");
		int [] test2 = {1, 2, 3, 4, 5};
		boolean leftRotate = true;
		int positions = 3;
		Utilities.rotate(test2, leftRotate, positions);
		int [] answer = {4, 5, 1, 2, 3};
		for(int i = 0; i < test2.length; i++) {
			System.out.print(test2[i] + " ");
			assertEquals(answer[i], test2[i]);
		}
	}
	@Test
	public void testRotate03() {
		System.out.println("\nTesting Rotate(Right once): ");
		int [] test3 = {1, 2, 3, 4, 5};
		boolean leftRotate = false;
		int positions = 1;
		Utilities.rotate(test3, leftRotate, positions);
		int [] answer = {5, 1, 2, 3, 4};
		for(int i = 0; i < test3.length; i++) {
			System.out.print(test3[i] + " ");
			assertEquals(answer[i], test3[i]);
		}
	}
	@Test
	public void testRotate04() {
		System.out.println("\nTesting Rotate(Left multiple times): ");
		int [] test4 = {1, 2, 3, 4, 5};
		boolean leftRotate = false;
		int positions = 3;
		Utilities.rotate(test4, leftRotate, positions);
		int [] answer = {3, 4, 5, 1, 2};
		for(int i = 0; i < test4.length; i++) {
			System.out.print(test4[i] + " ");
			assertEquals(answer[i], test4[i]);
		}
	}
	@Test
	public void testRotate05() {
		System.out.println("\nTesting Rotate(one element): ");
		int [] test5 = {1};
		boolean leftRotate = true;
		int positions = 3;
		int [] answer = {1};
		Utilities.rotate(test5, leftRotate, positions);
		System.out.print(test5[0] + " ");
		assertEquals(answer[0], test5[0]);
	}
	@Test
	public void testRotate06() {
		System.out.println("\nTesting Rotate(null): ");
		int [] test5 = null;
		boolean leftRotate = true;
		int positions = 3;
		try {
		Utilities.rotate(test5, leftRotate, positions);
		} catch(IllegalArgumentException e) {
			assertEquals("Null Array", e.getMessage());
		}
	}
}

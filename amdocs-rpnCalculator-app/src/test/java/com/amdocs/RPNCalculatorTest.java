package com.amdocs;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RPNCalculatorTest {
	
	private RPNCalculator rpnCalculator;
	private double actualResult, expectedResult;
	
	@Before
	public void init(){
		rpnCalculator = new RPNCalculator();
		actualResult = expectedResult = 0.0;
		System.out.println("Test CLASS 1");
	}
	
	@After
	public void cleanUp() {
		rpnCalculator = null;
	}

	@Test
	public void testSimpleAddition() {
		
		actualResult = rpnCalculator.evaluate("10 15 +");
		expectedResult = 25.0;
		assertEquals(expectedResult, actualResult, 0.0001);
		
		actualResult = rpnCalculator.evaluate("10 115 +");
		expectedResult = 125.0;
		assertEquals(expectedResult, actualResult, 0.0001);
	}
	
	@Test
	public void testSimpleSubtraction() {
				
		actualResult = rpnCalculator.evaluate("10 5 -");
		expectedResult = 5.0;
		assertEquals(expectedResult, actualResult, 0.0001);
		
		actualResult = rpnCalculator.evaluate("130 115 -");
		expectedResult = 15.0;
		assertEquals(expectedResult, actualResult, 0.0001);
	}
	
	@Test
	public void testSimpleMultiplication() {
				
	    actualResult = rpnCalculator.evaluate("10 5 *");
		expectedResult = 50.0;
		assertEquals(expectedResult, actualResult, 0.0001);
		
		actualResult = rpnCalculator.evaluate("130 10 *");
		expectedResult = 1300.0;
		assertEquals(expectedResult, actualResult, 0.0001);
	}
	
	@Category(SmokeTest.class)
	@Test
    public void testSimpleDivision() {
		System.out.println("division method");
		actualResult = rpnCalculator.evaluate("10 5 /");
		expectedResult = 2.0;
		assertEquals(expectedResult, actualResult, 0.0001);
		
		actualResult = rpnCalculator.evaluate("10 10 + 100 20 / *");
		expectedResult = 100.0;
		assertEquals(expectedResult, actualResult, 0.0001);
	}
	
}

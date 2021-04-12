package com.calculator.junit.first;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class calculatorEngineTest {
	calculatorEngine myCalc = new calculatorEngine();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOperationPlus() {
		double result = myCalc.operatePlus(10.0, 10.0);
		assertEquals(20.0, result, 0);
	}

	@Test
	public void testOperationMinus() {
		double result = myCalc.operateMinus(10.0, 10.0);
		assertEquals(0.0, result, 0);
	}

	@Test
	public void testOperationMultiply() {
		double result = myCalc.operateMultiply(10.0, 10.0);
		assertEquals(100.0, result, 0);
	}

	@Test
	public void testOperationDevide() throws DivideByZeroException {
		double result = myCalc.operateDevide(10.0, 10.0);
		assertEquals(1.0, result, 0);
	}

	@Test(expected = DivideByZeroException.class)
	public void testDevideByZeroException() throws DivideByZeroException {
		double result = myCalc.operateDevide(10.0, 0.0);
		assertEquals(0.0, result, 0);
	}

	@Test
	public void testCalcResultPlus() throws DivideByZeroException {
		String testPlus = "+";
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.calcResult(firstNumber, testPlus, secondNumber);
		Assert.assertEquals(13.0, result, 0);
	}

	@Test
	public void testCalcResultMinus() throws DivideByZeroException {
		String testMinus = "-";
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.calcResult(firstNumber, testMinus, secondNumber);
		Assert.assertEquals(-5.0, result, 0);
	}

	@Test
	public void testCalcResultMultiply() throws DivideByZeroException {
		String testMultiply = "*";
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.calcResult(firstNumber, testMultiply, secondNumber);
		Assert.assertEquals(36.0, result, 0);
	}

	@Test
	public void testCalcResultDevide() throws DivideByZeroException {
		String testDevide = "/";
		double firstNumber = 8;
		double secondNumber = 2;
		double result = myCalc.calcResult(firstNumber, testDevide, secondNumber);
		Assert.assertEquals(4.0, result, 0);
	}

	@Test
	public void testCheckValidTrue() {
		String testParameter = "+";
		boolean isValidOperation = calculatorEngine.checkValid(testParameter);
		Assert.assertTrue(isValidOperation);
	}

	@Test
	public void testCheckValidFalse() {
		String testParameter = "qwe";
		boolean isValidOperation = calculatorEngine.checkValid(testParameter);
		Assert.assertTrue(isValidOperation == false);
	}
}

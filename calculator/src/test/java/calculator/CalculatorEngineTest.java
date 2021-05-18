package calculator;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorEngineTest {
	CalculatorEngine myCalc;

	public static void main(String[] args) throws IOException {
	}

	@Before
	public void setUp() throws Exception {
		myCalc = new CalculatorEngine();
	}

	@After
	public void tearDown() throws Exception {
		myCalc = null;
	}

	@Test
	public void testOperationPlus() {
		double result = myCalc.plus(10.0, 10.0);
		assertEquals(20.0, result, 0);
	}

	@Test
	public void testOperationMinus() {
		double result = myCalc.minus(10.0, 10.0);
		assertEquals(0.0, result, 0);
	}

	@Test
	public void testOperationMultiply() {
		double result = myCalc.multiply(10.0, 10.0);
		assertEquals(100.0, result, 0);
	}

	@Test
	public void testOperationDevide() throws DivideByZeroException {
		double result = myCalc.devide(10.0, 10.0);
		assertEquals(1.0, result, 0);
	}

	@Test(expected = DivideByZeroException.class)
	public void testDevideByZeroException() throws DivideByZeroException {
		myCalc.devide(10.0, 0.0);
	}

	@Test
	public void testCalcResultPlus() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.result(firstNumber, Operation.PLUS, secondNumber);
		Assert.assertEquals(13.0, result, 0);
	}

	@Test
	public void testCalcResultMinus() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.result(firstNumber, Operation.MINUS, secondNumber);
		Assert.assertEquals(-5.0, result, 0);
	}

	@Test
	public void testCalcResultMultiply() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.result(firstNumber, Operation.MULTIPLY, secondNumber);
		Assert.assertEquals(36.0, result, 0);
	}

	@Test(expected = OperationNotSupportedException.class)
	public void testCalcResultUnknown() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 4;
		double secondNumber = 9;
		myCalc.result(firstNumber, Operation.UNKNOWN, secondNumber);
	}

	@Test
	public void testCalcResultDevide() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 8;
		double secondNumber = 2;
		double result = myCalc.result(firstNumber, Operation.DEVIDE, secondNumber);
		Assert.assertEquals(4.0, result, 0);
	}

	@Test
	public void testCheckValidTrue() {
		boolean isValidOperation = CalculatorEngine.checkValid(Operation.PLUS);
		Assert.assertTrue(isValidOperation);
	}

	@Test
	public void testCheckValidFalse() {
		boolean isValidOperation = CalculatorEngine.checkValid(Operation.UNKNOWN);
		Assert.assertTrue(isValidOperation == false);
	}
}

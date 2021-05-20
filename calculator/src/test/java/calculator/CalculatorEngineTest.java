package calculator;

import javax.naming.OperationNotSupportedException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorEngineTest extends BaseCalcEngineTest {

	@Test
	public void testResultPlus() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.result(firstNumber, Operation.PLUS, secondNumber);
		Assert.assertEquals(13.0, result, 0);
	}

	@Test
	public void testResultMinus() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.result(firstNumber, Operation.MINUS, secondNumber);
		Assert.assertEquals(-5.0, result, 0);
	}

	@Test
	public void testResultMultiply() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 4;
		double secondNumber = 9;
		double result = myCalc.result(firstNumber, Operation.MULTIPLY, secondNumber);
		Assert.assertEquals(36.0, result, 0);
	}

	@Test
	public void testResultDevide() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 8;
		double secondNumber = 2;
		double result = myCalc.result(firstNumber, Operation.DEVIDE, secondNumber);
		Assert.assertEquals(4.0, result, 0);
	}

	@Test(expected = OperationNotSupportedException.class)
	public void testResultUnknown() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 4;
		double secondNumber = 9;
		myCalc.result(firstNumber, Operation.UNKNOWN, secondNumber);
	}

	@Test(expected = DivideByZeroException.class)
	public void testDevideByZeroException() throws DivideByZeroException {
		myCalc.devide(10.0, 0.0);
	}

	@Test
	public void testCheckValidTrue() {
		Assert.assertTrue(myCalc.isOperationValid(Operation.PLUS));
	}

	@Test
	public void testCheckValidFalse() {
		Assert.assertFalse(myCalc.isOperationValid(Operation.UNKNOWN));
	}
}

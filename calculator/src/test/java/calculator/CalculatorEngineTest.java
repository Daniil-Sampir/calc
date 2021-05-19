package calculator;

import javax.naming.OperationNotSupportedException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorEngineTest extends BaseCalcEngineTest {

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

	@Test
	public void testCalcResultDevide() throws DivideByZeroException, OperationNotSupportedException {
		double firstNumber = 8;
		double secondNumber = 2;
		double result = myCalc.result(firstNumber, Operation.DEVIDE, secondNumber);
		Assert.assertEquals(4.0, result, 0);
	}

	@Test(expected = OperationNotSupportedException.class)
	public void testCalcResultUnknown() throws DivideByZeroException, OperationNotSupportedException {
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
		boolean isValidOperation = CalculatorEngine.isOperationValid(Operation.PLUS);
		Assert.assertTrue(isValidOperation);
	}

	@Test
	public void testCheckValidFalse() {
		boolean isValidOperation = CalculatorEngine.isOperationValid(Operation.UNKNOWN);
		Assert.assertFalse(isValidOperation);
	}
}

package calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class MinusDrivenTest {
	CalculatorEngine myCalc = new CalculatorEngine();
	int firstNumber;
	int secondNumber;
	int result;

	public MinusDrivenTest(int firstNumber, int secondNumber, int result) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> dataForTestMinus() {
		Object[][] data = new Object[][] { { 23, 1, 22 }, { 12, 2, 10 }, { 43, 3, 40 }, { 4, 4, 0 } };
		return Arrays.asList(data);
	}

	@Test
	public void drivenTestMinus() {
		assertEquals(result, myCalc.minus(firstNumber, secondNumber), 0);
	}
}
package calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class MultiplayDrivenTest {
	CalculatorEngine myCalc = new CalculatorEngine();
	double firstNumber;
	double secondNumber;
	double result;

	public MultiplayDrivenTest(int firstNumber, int secondNumber, int result) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> dataForTestMultiplay() {
		Object[][] data = new Object[][] { { 2, 2, 4 }, { 12, 2, 24 }, { 100, 10, 1000 }, { 123, 23, 2829 } };
		return Arrays.asList(data);
	}

	@Test
	public void drivenTestMultiplay() {
		assertEquals(result, myCalc.multiply(firstNumber, secondNumber), 0);
	}
}
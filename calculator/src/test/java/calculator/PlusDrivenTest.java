package calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class PlusDrivenTest extends BaseCalcEngineTest {
	double firstNumber;
	double secondNumber;
	double result;

	public PlusDrivenTest(int firstNumber, int secondNumber, int result) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> dataForTestPlus() {
		Object[][] data = new Object[][] { { 1, 23, 24 }, { 2, 12, 14 }, { 3, 43, 46 }, { 4, 4, 8 } };
		return Arrays.asList(data);
	}

	@Test
	public void testPlus() {
		assertEquals(result, myCalc.plus(firstNumber, secondNumber), 0);
	}
}
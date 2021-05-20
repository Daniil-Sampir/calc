package calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class DevideDrivenTest extends BaseCalcEngineTest {
	double firstNumber;
	double secondNumber;
	double result;

	public DevideDrivenTest(int firstNumber, int secondNumber, int result) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> dataForTestDevide() {
		Object[][] data = new Object[][] { { 58, 2, 29 }, { 95, 5, 19 }, { 9, 3, 3 }, { 4, 4, 1 } };
		return Arrays.asList(data);
	}

	@Test
	public void testDevide() throws DivideByZeroException {
		assertEquals(result, myCalc.devide(firstNumber, secondNumber), 0);
	}
}

package calculator;

import org.junit.After;
import org.junit.Before;

public class BaseCalcEngineTest {
	CalculatorEngine myCalc;

	@Before
	public void setUp() throws Exception {
		myCalc = new CalculatorEngine();
	}

	@After
	public void tearDown() throws Exception {
		myCalc = null;
	}
}

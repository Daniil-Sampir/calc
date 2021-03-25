import java.util.Scanner;

public class MainCalculator extends CalculatorEngine {
	static MainCalculator myCalculator = new MainCalculator();

	public static void main(String[] args) {
		while (true) {
		double result = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first number:");
		double firstNumber = myCalculator.scannerNumbers();

		System.out.println("Enter the operation(+,-,/,*):");
		String operation = myCalculator.operation();

		System.out.println("Enter the second number:");
		double secondNumber = myCalculator.scannerNumbers();
		while (true) {
			try {
				result = myCalculator.calcResult(firstNumber, operation, secondNumber);
				System.out.println("result:" + result);
			} catch (ArithmeticException e) {
				System.out.println("Divided by zero operation cannot possible");
			}
			break;
		}
		System.out.println("Do you want to continue? yes, no");
		while (true) {
			String finish = scanner.nextLine();
			if (finish.equals("yes")) {
				break;
			}
			if (finish.equals("no")) {
				return;
			}
			System.out.println("Error, please enter yes or no");
		}
	}
}
}

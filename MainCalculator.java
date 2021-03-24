import java.util.Scanner;

public class MainCalculator extends CalculatorEngine {
	static MainCalculator myCalculator = new MainCalculator();

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the first number:");
			double firstNumber = myCalculator.ScannerNumbers();

			System.out.println("Enter the operation:");
			String operation = myCalculator.Operation();

			System.out.println("Enter the second number:");
			double secondNumber = myCalculator.ScannerNumbers();

			double result = myCalculator.Result(firstNumber, operation, secondNumber);
			while (true) {
				if (secondNumber == 0) {
					String mistake = "Error: trying to divide by zero";
					System.out.println(mistake);
					break;
				}
				System.out.println("result:" + result);
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

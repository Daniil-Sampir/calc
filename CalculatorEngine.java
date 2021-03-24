import java.util.Scanner;

public class CalculatorEngine {
	public double ScannerNumbers() {
		Scanner scanner = new Scanner(System.in);
		double Number = 0;
		while (true) {
			String Num = scanner.nextLine();
			try {
				Number = Double.parseDouble(Num);
			} catch (NumberFormatException e) {
				System.out.println("Error: incorrect entry, please enter a number");
			}
			return Number;
		}
	}

	public String Operation() {
		Scanner scanner = new Scanner(System.in);
		String operation;
		while (true) {
			String checkOperation = scanner.nextLine();
			boolean isOperationValid = checkValid(checkOperation);
			if (isOperationValid) {
				operation = checkOperation;
				return operation;
			} else {
				System.out.println("Error: unknown operation, enter (+,-,/,*): ");
			}
		}
	}

	public static Boolean checkValid(String Unit) {
		String operateMinus = "-";
		String operatePlus = "+";
		String operateDevide = "/";
		String operateMultiply = "*";
		if (Unit.equals(operateMinus) || Unit.equals(operatePlus) || Unit.equals(operateMultiply)
				|| Unit.equals(operateDevide)) {
			return true;
		} else {
			return false;
		}
	}

	public double Result(double firstNumber, String operation, double secondNumber) {
		double result = 0;
		if (operation.equals("+")) {
			result = operatePlus(firstNumber, operation, secondNumber);
		}
		if (operation.equals("-")) {
			result = operateMinus(firstNumber, operation, secondNumber);
		}
		if (operation.equals("*")) {
			result = operateMultiply(firstNumber, operation, secondNumber);
		}
		if (operation.equals("/")) {
			result = operateDevide(firstNumber, operation, secondNumber);
		}
		return result;
	}

	public double operatePlus(double firstNumber, String operation, double secondNumber) {
		double result = 0;
		result = firstNumber + secondNumber;
		return result;
	}

	public double operateMinus(double firstNumber, String operation, double secondNumber) {
		double result = 0;
		result = firstNumber - secondNumber;
		return result;
	}

	public double operateMultiply(double firstNumber, String operation, double secondNumber) {
		double result = 0;
		result = firstNumber * secondNumber;
		return result;
	}

	public double operateDevide(double firstNumber, String operation, double secondNumber) {
		double result = 0;
		result = firstNumber / secondNumber;
		return result;
	}
}
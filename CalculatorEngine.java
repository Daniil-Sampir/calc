import java.util.Scanner;

public class CalculatorEngine {
	public double scannerNumbers() {
		Scanner scanner = new Scanner(System.in);
		double Number = 0;
		while (true) {
			String Num = scanner.nextLine();
			try {
				Number = Double.parseDouble(Num);
			} catch (NumberFormatException e) {
				System.out.println("Error: incorrect entry, please enter a number");
				continue;
			}
			return Number;
		}
	}

	public String operation() {
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

	public static Boolean checkValid(String unit) {
		String operateMinus = "-";
		String operatePlus = "+";
		String operateDevide = "/";
		String operateMultiply = "*";
		if (unit.equals(operateMinus) || unit.equals(operatePlus) || unit.equals(operateMultiply)
				|| unit.equals(operateDevide)) {
			return true;
		} else {
			return false;
		}
	}

	public double calcResult(double firstNumber, String operation, double secondNumber) {
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
		return firstNumber + secondNumber;
	}

	public double operateMinus(double firstNumber, String operation, double secondNumber) {
		return firstNumber - secondNumber;
	}

	public double operateMultiply(double firstNumber, String operation, double secondNumber) {
		return firstNumber * secondNumber;
	}

	public double operateDevide(double firstNumber, String operation, double secondNumber) {
		double result = 0;
		if (secondNumber == 0) {
			throw new ArithmeticException("Divided by zero operation cannot possible");
		}
		result = firstNumber / secondNumber;
		return result;
	}
}

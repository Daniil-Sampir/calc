package calculator;

import java.io.InputStream;
import java.util.Scanner;

import javax.naming.OperationNotSupportedException;

enum Operation {
	MINUS, PLUS, DEVIDE, MULTIPLY, UNKNOWN
}

public class CalculatorEngine {

	Scanner scanner = new Scanner(System.in);

	public double scannerNumbers() {
		double number = Double.parseDouble(scanner.nextLine());
		return number;
	}

	public Operation operation() {
		while (true) {
			String checkOperation = scanner.nextLine();
			Operation operation = operationTest(checkOperation);
			boolean isOperationValid = checkValid(operation);
			if (isOperationValid) {
				return operation;
			} else {
				System.out.println("Error: unknown operation, enter (+,-,/,*): ");
			}
		}
	}

	public static Operation operationTest(String string) {
		if (string.equals("+")) {
			return Operation.PLUS;
		}
		if (string.equals("-")) {
			return Operation.MINUS;
		}
		if (string.equals("*")) {
			return Operation.MULTIPLY;
		}
		if (string.equals("/")) {
			return Operation.DEVIDE;
		}
		return Operation.UNKNOWN;
	}

	public static Boolean checkValid(Operation unit) {
		if (unit.equals(Operation.UNKNOWN)) {
			return false;
		} else {
			return true;
		}
	}

	public double result(double firstNumber, Operation operation, double secondNumber)
			throws DivideByZeroException, OperationNotSupportedException {
		switch (operation) {
		case DEVIDE:
			return devide(firstNumber, secondNumber);
		case MINUS:
			return minus(firstNumber, secondNumber);
		case MULTIPLY:
			return multiply(firstNumber, secondNumber);
		case PLUS:
			return plus(firstNumber, secondNumber);
		case UNKNOWN:
		default:
			throw new OperationNotSupportedException("");
		}
	}

	public double plus(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

	public double minus(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}

	public double multiply(double firstNumber, double secondNumber) {
		return firstNumber * secondNumber;
	}

	public double devide(double firstNumber, double secondNumber) throws DivideByZeroException {
		if (secondNumber == 0) {
			throw new DivideByZeroException("Divided by zero operation cannot possible");
		}
		return firstNumber / secondNumber;
	}
}

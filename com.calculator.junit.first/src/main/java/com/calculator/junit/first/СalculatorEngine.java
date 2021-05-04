package com.calculator.junit.first;

import java.io.InputStream;
import java.util.Scanner;

public class ÑalculatorEngine {

	Scanner scanner = new Scanner(System.in);
	String operation;

	public double scannerNumbers() {
		double number = Double.parseDouble(scanner.nextLine());
		return number;
	}

	public String operation() {
		while (true) {
			String checkOperation = scanner.nextLine();
			boolean isOperationValid = checkValid(checkOperation);
			if (isOperationValid) {
				return operation = checkOperation;
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

	public double calcResult(double firstNumber, String operation, double secondNumber) throws DivideByZeroException {
		double result = 0;
		if (operation.equals("+")) {
			result = operatePlus(firstNumber, secondNumber);
		}
		if (operation.equals("-")) {
			result = operateMinus(firstNumber, secondNumber);
		}
		if (operation.equals("*")) {
			result = operateMultiply(firstNumber, secondNumber);
		}
		if (operation.equals("/")) {
			result = operateDevide(firstNumber, secondNumber);
		}
		return result;
	}

	public double operatePlus(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

	public double operateMinus(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}

	public double operateMultiply(double firstNumber, double secondNumber) {
		return firstNumber * secondNumber;
	}

	public double operateDevide(double firstNumber, double secondNumber) throws DivideByZeroException {
		if (secondNumber == 0) {
			throw new DivideByZeroException("Divided by zero operation cannot possible");
		}
		return firstNumber / secondNumber;
	}
}

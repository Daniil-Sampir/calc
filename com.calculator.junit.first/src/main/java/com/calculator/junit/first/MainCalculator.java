package com.calculator.junit.first;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCalculator {
	static ÑalculatorEngine myCalculator = new ÑalculatorEngine();

	public static void main(String[] args) {
		while (true) {
			double firstNumber = 0;
			double secondNumber = 0;
			double result = 0;
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("Enter the first number:");
				try {
					firstNumber = myCalculator.scannerNumbers();
				} catch (NumberFormatException e) {
					System.out.println("Error, invalid input lease insert a number");
					continue;
				}
				break;
			}

			System.out.println("Enter the operation(+,-,/,*):");
			String operation = myCalculator.operation();

			while (true) {
				System.out.println("Enter the second number:");
				try {
					secondNumber = myCalculator.scannerNumbers();
				} catch (NumberFormatException e) {
					System.out.println("Error, invalid input please insert a number");
					continue;
				}
				break;
			}

			while (true) {
				try {
					result = myCalculator.calcResult(firstNumber, operation, secondNumber);
					System.out.println("result:" + result);
				} catch (DivideByZeroException e) {
					System.out.println("Divided by zero operation cannot possible");
				}
				break;
			}
		}
	}
}
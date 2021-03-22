import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
		double result = 0;
		double firstNum = 0;
		double secondNum = 0;
		String operation;
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		while (true) {
			while (true) {
				System.out.println("Enter the first number:");
				String num1 = scan1.nextLine();
				try {
					firstNum = Double.parseDouble(num1);
				} catch (NumberFormatException e) {
					System.out.println("Error: incorrect entry, please enter a number");
					continue;
				}
				break;
			}
			while (true) {
				System.out.println("Enter operation (+,-,*,/):");
				String operate = scan2.nextLine();
				boolean isOperationValid = checkValid(operate);
				if (isOperationValid) {
					operation = operate;
				} else {
					System.out.println("Error: unknown operation, enter (+,-,/,*): ");
					continue;
				}
				break;
			}
			while (true) {
				System.out.println("Enter the second number:");
				String num2 = scan1.nextLine();
				try {
					secondNum = Double.parseDouble(num2);
				} catch (NumberFormatException r) {
					System.out.println("Error: incorrect entry, please enter a number");
					continue;
				}
				break;
			}
			while (true) {
				if (operation.equals("+")) {
					result = firstNum + secondNum;
				}
				if (operation.equals("-")) {
					result = firstNum - secondNum;
				}
				if (operation.equals("*")) {
					result = firstNum * secondNum;
				}
				if (operation.equals("/")) {
					result = firstNum / secondNum;
					if (secondNum == 0) {
						String mistake = "Error: trying to divide by zero";
						System.out.println(mistake);
						break;
					}
				}
				System.out.println("Result: " + result);
				break;
			}
			System.out.println("Do you want to continue? yes, no");
			while (true) {
				String finish = scan3.nextLine();
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
}
public class qwe {
	public static void main(String[] args) {
		try {
			int number = 100 / 0;
			System.out.println(number);
		} catch (Exception e) {
			System.out.println("Caught Exception while trying to divide 100 by zero ");
		}
	}
}
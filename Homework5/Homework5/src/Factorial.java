
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int outcome = 0;
		
		outcome = factorial(5);
      System.out.println(outcome);
	}

	public static int factorial(int number) {
		int result = 0;
		int index = 0;
		if (number < 0) {
			return -1;
		} else if (number == 0 || number == 1) {
			return 1;
		} else {
			result = number;
			index = number - 1;
			while (index > 0) {
				result *= index;
				index -= 1;
			}
			return result;
		}
	}
}

import java.util.HashSet;

public class FunSum {
	private static int N;										// Size of the array.
	private static char[] array;						// Stores the equation.

	/**
		Evaluates the value of the equation stored in the array.
	*/
	private static int evaluateArray() {
		int num = 0;
		int sum = 0;

		char prevSymbol = ' ';
		for (char x: array) {
			if (x == ' ')
				continue;
			if (x == '+' || x == '-') {
				if (prevSymbol != ' ') {
					sum = sum + ((prevSymbol == '+') ? num : -num);
				}
				else {
					sum = sum + num;
				}
				prevSymbol = x;
				num = 0;
			}
			else {
				int digit = ((int)x - (int)'0');
				num = 10 * num + digit;
			}
		}
		sum = sum + ((prevSymbol == '+' || prevSymbol == ' ') ? num : -num);
		return sum;
	}
	
	/**
		Print the solution, equation followed by its value. 
	*/
	private static void printSolution() {
		for (char x: array) {
			if (x == ' ')
				continue;
			if (x == '+' || x == '-')
				System.out.print(" " + x + " ");
			else
				System.out.print(x);
		}
		System.out.println(" = " + evaluateArray());
	}

	public static void search(int index) {
		// TODO: Perform a recursive search of the array sequence from index onward. 
		if(evaluateArray() == 100){
			printSolution();
			return;
		}

		if(index >= N){
			return;
		}

		array[index] = '+';
		search(index+2);

		array[index] = '-';
		search(index+2);


		array[index] = ' ';
		search(index+2);
			
	}
	
	public static void main(String [] args) {
		// Initialize variables.
		N = 17;
		array = new char[N];
		
		// Create the character array with elements 1 ' ' 2 ' ' ...
		// All even indexed elements contain a digit, and all odd indexed elements contain a ' '.
		for (int i = 0, j = 1; i < N; i++) {
			if ((i & 0x01) == 0)
				array[i] = (char) (j++ + (int) '0');
			else
				array[i] = ' ';
		}
		// Calling the recursive search routine to search for all possible solutions.
		search(1);
	}
}

import java.util.Scanner;

public class Collatz {

	static int maximum = 100000000;
	static int[] table = new int[maximum+1];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		System.out.print("Enter the range: ");

		int a = scanner.nextInt();
		int b = scanner.nextInt();

		while(a > b){
			System.out.println("Invalid input, first number must be smaller than the second.");
			a = scanner.nextInt();
			b = scanner.nextInt();
		}

		if(b > maximum){
			b = maximum;
		}

		long maxV = 1;
		int maxC = 1;

		for (int val = a; val <= b; val++) {

			int len = collatzLength(val);
			if (len > maxC) {
				maxV = val;
				maxC = len;
			}
		}

		System.out.println("The number with the maximum Collatz length in the range: " + maxV);
		System.out.println("Its Collatz length: " + maxC);

		scanner.close();
	}

	public static int collatzLength(long n) {
		int length = 0;

		boolean limit = false;

		if(n > maximum){
			limit = true;
		}

		if(limit == false){
		if(table[ (int) n] != 0){
			return table[ (int) n];
		}}

		if(n == 1){
			return 1;
		}else if(n % 2 == 0){
			length = 1 + collatzLength(n/2);
		}else{
			length = 1 + collatzLength(3*n + 1);
		}

		if(limit == false){
		if(table[ (int) n] == 0){
			table[ (int) n] = length;
		}}

		return length;
	}
}

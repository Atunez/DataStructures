import java.lang.Integer;

public class Prog {

	public static void main(String [] args) {
		
		if (args.length != 2) {
			System.out.println("Please execute: java Prog <n> <p>");
			System.out.println("n is the input size, and p is the program number.");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);

		switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static void prog1(int n) {

		// TODO: Code to generate n keys that all get hashed to the same index using hash1.	

		HashFunctions hash = new HashFunctions(n);

		for(int i = 0; i < n; i++){
			if(hash.hash1((i*n)+1) == hash.hash1(((i+1)*n)+1)){
					System.out.println( (i*n)+1 );
			}
		}
		

	}

	private static void prog2(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash2.	

		HashFunctions hash = new HashFunctions(n);

		int i = 1;
		int number = hash.hash2(0);
		int counter = 1;

		System.out.println(0);

		while(counter < n){
			if(hash.hash2(i) == number){
				counter++;
				System.out.println(i);
			}
			i++;
		}		
	}

	private static void prog3(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.	

		HashFunctions hash = new HashFunctions(n);

		int number = hash.hash3(0);
		System.out.println(0);

		for(int i = 1; i < n; i++){
			if(hash.hash3( (int) (i*128189L)) == number){
				System.out.println(i*128189L);
			}
		}
		
	}

	private static void prog4(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.	

		HashFunctions hash = new HashFunctions(n);

		int number = hash.hash4(0);
		System.out.println(0);

		int output = 1;
		int i = 1;

		while(output != n){
			if(hash.hash4(i) == hash.hash4(0)){
				System.out.println(i);
				output++;
			}
			i++;
		}

	}
}

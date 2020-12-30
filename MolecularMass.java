import java.util.*;

public class MolecularMass{

	public final static int  C = 12;
	public final static int  H = 1;
	public final static int  O = 16;

	public static void main(String[] args){

		Scanner k = new Scanner(System.in);
		System.out.print("Enter the molecule: ");
		String molecule = k.nextLine();


		IntStack currentStack = new IntStack();

		for(int i = 0; i < molecule.length(); i++){

			char atom = molecule.charAt(i);

			if('2' <= atom && atom <= '9'){
				int temp = currentStack.pop();
				temp *= Character.getNumericValue(atom);
				currentStack.push(temp);
				continue;
			}


			if(atom == 'C'){
				currentStack.push(C);
				continue;
			}

			if(atom == 'H'){
				currentStack.push(H);
				continue;
			}


			if(atom == 'O'){
				currentStack.push(O);
				continue;
			}

			if(atom == '('){
				currentStack.push(-2);
				continue;
			}

			if(atom == ')'){
				int temp = 0;
				int temppop = currentStack.pop();
				while(temppop != -2){
					temp += temppop;
					temppop = currentStack.pop();
				}
				currentStack.push(temp);
				continue;
			}



		} 

		int result = 0;
		int poptemp = currentStack.pop();

		while(poptemp != -1){
			result += poptemp;
			poptemp = currentStack.pop();
		}

		System.out.println("The Molecular Mass of " + molecule + " is " + result);

	}
}

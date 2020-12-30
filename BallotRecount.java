import java.util.Scanner;


public class BallotRecount{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		kb.nextLine();

		PersonSet voters = new PersonSet();
		while(n != 0){
			String person = kb.nextLine();
			String vote = kb.nextLine();
			
			voters.insert(person, vote);
			
			n--;
		}

		kb.close();

		voters.count();

	}
}
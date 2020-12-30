import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordLadder {
	private static String start;
	private static String end;
	private static StringMap T;			// This map stores the dictionary of words.
	private static StringMap R;			// This map keeps track of all the words that are visited during breadth-first-search.
																	// The key field is the word that is visited, and its value field can hold the predecessor pointer.
	private static Queue Q;					// A queue to perform the breadth-first-search.

	public static void main(String [] args) throws IOException {
		// Loading the dictionary of words into the StringMap T.
		T = new StringMap();
		File file = new File("dictionary4");
		Scanner f = new Scanner(file);
		while (f.hasNext()) {
			String word = f.nextLine();
			T.insert(word, "");
		}
		f.close();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the start word: ");
		start = kb.nextLine();
		System.out.print("Enter the end word: ");
		end = kb.nextLine();

		kb.close();

		// TODO: Solution to find the shortest set of words that transforms the start word to the end word.

		Q = new Queue();
		Q.enqueue(new QNode(0, start));

		R = new StringMap();
		R.insert(start, "");

		boolean answer = false;

		if(start.equals(end)){
			answer = true;
		}

		while(Q.isEmpty() == false && answer == false){
			QNode x = Q.dequeue();
			if(closest(x)){
				answer = true;
			}
		} 

		if (answer) {
			System.out.println("Yay! A word ladder is possible.");
			print(end);
		} else {
			System.out.println("Duh! Impossible.");
		}
	}

	public static boolean closest(QNode input){
		int dist = input.getDist();
		String word = input.getWord();
		
		for(int i = 0; i < word.length(); i++){
			StringBuilder edit = new StringBuilder(word);
			for(char change = 'a'; change <= 'z'; change++){
				edit.setCharAt(i, change);
				String changed = edit.toString();
				if(changed.equals(end)){
					R.insert(end, word);
					return true;
				}
				if(R.find(changed) == null && T.find(changed) != null){
					Q.enqueue(new QNode(dist + 1, changed));
					R.insert(changed, word);
				}
			}
		}

		return false;
	}

	public static void print(String end){
		if(end.equals("")){
			return;
		}

		StringNode toprint = R.find(end);
		print(toprint.getValue());

		System.out.println(end);
	}
}

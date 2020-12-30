public class PersonSet{

	PersonNode [] table;	// Hash table - collisions resolved through chaining.
	int numelements;	// Number of elements actually stored in the structure.
	int size;					// Allocated memory (size of the hash table).

	/** 
	 * Constructur: initilaizes numelements, size and initial table size.
	 */
	public PersonSet() {
		numelements = 0;
		size = 100;
		table = new PersonNode[size];
	}

	/*
	 * inserts a new key into the set. Inserts it at the head of the linked list given by its hash value.
	 */
	public void insert(String key, String person) {

		if (numelements == size) {
			// Expand the hash table and rehash its contents. 
			size = size * 2;
			PersonNode[] nTable = new PersonNode[size];

			for (int i = 0; i < table.length; i++) {
				nTable[hash(table[i].getKey())] = table[i];
			}
		}

		// Code for actual insert.
		PersonNode pers = find(key);
		if(pers == null){
			int i = hash(key);
			PersonNode temp = new PersonNode(key, table[i]);
			if(person.equals("A")){
				temp.updateA();
			}else{
				temp.updateB();
			}
			table[i] = temp;
		}else{
			if(person.equals("A")){
				pers.updateA();
			}else{
				pers.updateB();
			}
		}
	}

	/*
	 * finds if a String key is present in the data structure. Returns true if found, else false.
	 */
	public PersonNode find(String key) {
		int i = hash(key);
		for (PersonNode curr = table[i]; curr != null; curr = curr.getNext()) {
			if (curr.getKey().equals(key)) return curr;
		}
		return null;
	}

	/*
	 * Prints the contents of the hash table.
	 */
	public void print() {
		for (int i = 0; i < size; i++) {
			for (PersonNode curr = table[i]; curr != null; curr = curr.getNext()) {
				System.out.println(curr.getKey());
				System.out.println(curr.getA());
				System.out.println(curr.getB());
			}
		}
	}

	public void count(){
		int beforeA = 0;
		int beforeB = 0;

		int afterA = 0;
		int afterB = 0;

		for (int i = 0; i < size; i++) {
			for (PersonNode curr = table[i]; curr != null; curr = curr.getNext()) {
				if(curr.getA() != 0 && curr.getB() != 0){
					beforeA += curr.getA();
					beforeB += curr.getB();
				}else if(curr.getA() != 0 && curr.getB() == 0){
					beforeA += curr.getA();
					afterA += 1;			
				}else if(curr.getA() == 0 && curr.getB() != 0){
					beforeB += curr.getB();
					afterB += 1;
				}
			}
		}

		System.out.println("Before recount");
		System.out.println("Candidate A: " + beforeA);
		System.out.println("Candidate B: " + beforeB);
		System.out.println();
		System.out.println("After recount");
		System.out.println("Candidate A: " + afterA);
		System.out.println("Candidate B: " + afterB);
		System.out.println();
		if(afterA > afterB){
			System.out.println("Candidate A wins");
		}else if(afterA == afterB){
			System.out.println("It is a tie");
		}else{
			System.out.println("Candidate B wins");			
		}
		
	
	}

	/*
	 * The hash function that returns the index into the hash table for a string k.
	 */
	public int hash(String k) {
		int h = 69;
		int x = 109;

		// Compute a polynomial hash function for the String k. Make sure that the hash value h returned is a proper index 
		// in the hash table, ie. in the range [0...capacity-1]. 
		for (int i = 0; i < k.length(); i++) {
			h = ((h * x) + (int) k.charAt(i)) % size;
		}

		return h;
	}

}

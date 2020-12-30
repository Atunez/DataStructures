/*
 * This class maintains a set of ints. 
 */

public class IntSet {
	private Node base;
	private boolean placed;
	public IntSet(){
		base = new Node(0,null);
		placed = false;
	}

	/* Find if a key is present in the set. Returns true if the key is present, otehrwise false.*/
	public boolean find(int key) {
		Node tvr = base;
		while(tvr.next !=  null){
			if(tvr.digit == key) return true;
			tvr = tvr.next;
		}
		return false;
	}

	/* Insert a key into the set. */
	public void insert(int key) {
		// Make sure that the key is not present.
		assert (!find(key));

		// Perform insert.
		if(placed == false){
			base.digit = key;
			placed = true;
		}
		else{
			if(base.next == null) {
				if(base.digit > key) {
					Node temp = base;
					base = new Node(key, temp);
				}
				else {
					Node temp = new Node(key, null);
					base.next = temp;
				}
			}
			else {
				Node tvr;
				boolean p = false;
				for(tvr = base; tvr.next != null; tvr = tvr.next){
					if(base.digit > key) {
						Node temp = new Node(key, base);
						this.base = temp;
						p = true;
						break;
					}
					if(tvr.digit < key && tvr.next.digit > key){
						tvr.next = new Node(key, tvr.next);
						p = true;
						break;
					}
					if(tvr.next == null){
						tvr.next = new Node(key, null);
						p = true;
						break;
					}
				}
				if(p == false) {
					tvr.next = new Node(key, null);
				}
			}
		}
	}


	/* Remove a key from the set. */
	public void remove(int key) {
		// Make sure that the key is present.
		assert (find(key));

		if(base.next == null){
			base.digit = 0;
			placed = false;
		}

		Node tvr = base;

		while(tvr.next != null){
			if(tvr.next.digit == key){
				break;
			}
			tvr = tvr.next;
		}

		if(tvr.next.next == null) {
			tvr.next = null;
		}
		else {
			tvr.next = tvr.next.next;
		}
	}

	/* Print the contents of the set in sorted order. */
	public void print() {
		Node tvr;
		for(tvr = base; tvr.next != null; tvr = tvr.next){
			System.out.print(tvr.digit + " ");
		}
		System.out.println(tvr.digit);
	}
}

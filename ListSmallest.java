public class ListSmallest {

	private double smallest; 
	private ListNode header;
	private int special = 0;

	public ListSmallest(ListNode header){
		this.smallest = Double.POSITIVE_INFINITY;
		this.header = header;
	}

	public double getSmallest(){
		return this.smallest;
	}

	private void findsmall(int i){
		if(this.header == null || i == 10000){
			if(this.header == null){
				this.special = -1;
			}
			return;
		}
		if(this.smallest > this.header.num){
			this.smallest = this.header.num;
		}
		this.header = this.header.next;
		findsmall(i+1);
	}	
	private void findsmallest(int i){
		if(this.special == -1){
			return;
		}
		findsmall(0);
		findsmallest(i+1);
	}


	public static void main(String [] args) {
		
		// Creating an instance of MyList.
		MyList L = new MyList();

		// Get the head of the linked list.
		ListNode head = L.getHead();

		// Create an object of this program to avoid static context.
		ListSmallest l = new ListSmallest(head);
		l.findsmallest(0);

		// head is the head of my linked list L. 
		// TODO: please write a function to print the minimum element in this list. Please store this in the variable m.
		int m = (int) l.getSmallest(); // store the min in this variable.

		System.out.println("The smallest is " + m);
	}
}

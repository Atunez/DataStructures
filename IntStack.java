public class IntStack {
	// May create private data here.
	private Node head;

	// Deal w/ negative numbers (Just in case, not needed)
	private boolean empty; 

	public IntStack() {
		// TODO: Code to initialize your stack.
		head = new Node(0,null);
		empty = true;
	}

	public void push(int x) {
		// TODO: Code to push an item x onto the stack. The stack wlil never contain more than 100 elements.
		
		if(empty == true){
			head = new Node(x, null);
			empty = false;
		}else{
			Node temp = new Node(x, head);
			head = temp;
		}	
	}

	public int pop() {
		// TODO: Code to pop and retrun an item from the top of the stack. If the stack is empty, return -1.
		if(empty == true){
			return -1;
		}
		else{
			int temp = head.digit;
			if(head.next == null){
				empty = true;
			}else{
				head = head.next;
			}
			return temp;
		}
	}
}

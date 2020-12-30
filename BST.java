
public class BST {
	private Node root; // The root node of the tree.

	//For Pred and Succ
	private Node smallest;
	private Node largest;

	public BST() {
		root = null;
	}

	public boolean isEmpty(){
		if(root == null){
			return true;
		}
		return false;
	}

	/**
		Inserts a time, along with the req_id. The tree is keyed on time, while req_id provides a pointer to the request.
		This is a public wrapper function that calls the recursive insert method.
		Note that the insert method should return the root node of the subtree in which we insert the key (and its value).
	**/
	public void insert(int time, int req_index) {
		// TODO: Code for insert here.
		if(root == null){
			root = new Node(time, req_index);
			return;
		}
		root = insert(root, time, req_index);
	}

	private Node insert(Node current, int time, int req_index){
		if(current == null) return new Node(time, req_index);
		if(current.getTime() <= time){
			current.setRight( insert(current.getRight(), time, req_index) );
		}else{
			current.setLeft( insert(current.getLeft(), time, req_index) );
		}
		return current;
	}

	/**
		Returns a pointer to the Node that is the predecessor of time. The predecessor element is the largest
		element within the tree that is smaller or equal to time. This is the deepest ancestor with this property.
		Please return the predecessor element. You may return null if time does not have a predecessor.
	**/

	private Node pred(Node current, int time){
		if(current == null){
			return smallest;
		}
		if(current.getTime() == time){
			if(current.getLeft() != null){
				return max(current.getLeft());
			}
			return smallest;
		}
		if(current.getTime() > time){
			return pred(current.getLeft(), time);
		}
		else{
			smallest = current;
			return pred(current.getRight(), time);
		}
		
	}


	public Node pred(int time) {
		// TODO: code for pred here.
		smallest = null;
		if(min().getTime() > time){
			return null;
		}
		return pred(root, time);
			
	}

	/**
		Returns a pointer to the Node that is the successor of time. The successor element is the smallest
		element within the tree that is larger or equal to time. This is the deepest ancestor with this property.
		Please return the successor element. You may return null if time does not have a successor.
	**/
	
	private Node succ(Node current, int time){
		if(current == null){
			return largest;
		}
		if(current.getTime() == time){
			if(current.getRight() != null){
				return min(current.getRight());
			}
			return largest;
		}
		if(current.getTime() < time){
			return succ(current.getRight(), time);
		}
		else{
			largest = current;
			return succ(current.getLeft(), time);
		}
	}

	public Node succ(int time) {
		// TODO: code for succ here.
		largest = null;
		if(max().getTime() < time){
			return null;
		}
		return succ(root, time);
	}

	/**
		Returns the minimum element in the binary search tree or null if the tree is empty.
	**/

	private Node min(Node start) {
		// TODO: Code for min here.
		Node current = start;
		if(current == null){
			return null;
		}
		for(;;){
			if(current.getLeft() == null){
				return current;
			}else{
				current = current.getLeft();
			}
		}
	}

	public Node min() {
		// TODO: Code for min here.
		Node current = root;
		if(current == null){
			return null;
		}
		for(;;){
			if(current.getLeft() == null){
				return current;
			}else{
				current = current.getLeft();
			}
		}
	}

	/**
		Returns the maximum element in the binary search tree or null if the tree is empty.
	**/
	private Node max(Node start){
		Node current = start;
		if(current == null){
			return null;
		}
		for(;;){
			if(current.getRight() == null){
				return current;
			}else{
				current = current.getRight();
			}
		}

	}

	public Node max() {
		// TODO: Code for max here.
		Node current = root;
		if(current == null){
			return null;
		}
		for(;;){
			if(current.getRight() == null){
				return current;
			}else{
				current = current.getRight();
			}
		}
	}

	/**
		Remove the node that contains this time. If this time is not present in the structure, this method does nothing.
	**/

	private Node find(Node current, int time){
		if(current == null){
			return null;
		}
		if(current.getRight() != null){
			if(time == current.getRight().getTime()){
				return current;
			}
		}
		if(current.getLeft() != null){
			if(time == current.getLeft().getTime()){
				return current;
			}
		}
		if(time > current.getTime()){
			return find(current.getRight(), time);
		}
		if(time < current.getTime()){
			return find(current.getLeft(), time);
		}
		else{
			return null;
		}
	}

	private void deleteRoot(){
		if(root.getRight() == null && root.getLeft() == null){
			root = null;
			return;
		}
		if(root.getRight() == null && root.getLeft() != null){
			root = root.getLeft();
			return;
		}
		if(root.getRight() != null && root.getLeft() == null){
			root = root.getRight();
			return;
		}

		Node succ = succ(root.getTime());
		//System.out.println(succ);
		if(succ == null){
			return;
		}
		Node base2 = find(root, succ.getTime());
		if(base2 == null){
			return;
		}
		delete(base2, succ);
		root.setTime(succ.getTime());
		root.setReq_index(succ.getReq_index());

	}


	private void delete(Node parent, Node child){
		
		// No Children ;-;

		if(child.getRight() == null && child.getLeft() == null){
			if(parent.getRight() == child){
				parent.setRight(null);
			}else{
				parent.setLeft(null);
			}
			return;
		}
	
		// 1 Child 

		if( (child.getRight() != null && child.getLeft() == null) || (child.getRight() == null && child.getLeft() != null) ){
			if(child.getRight() != null && child.getLeft() == null){
				if(parent.getRight() == child){
					parent.setRight(child.getRight());
				}else{
					parent.setLeft(child.getRight());
				}	
			}else{
				if(parent.getRight() == child){
					parent.setRight(child.getLeft());
				}else{
					parent.setLeft(child.getLeft());
				}	

			}
			return;
		}
		
		print();

		// 2 Children
		if( child.getRight() != null && child.getLeft() != null){
			Node succ = succ(child.getTime());
			//System.out.println(succ);
			if(succ == null){
				return;
			}
			Node base2 = find(root, succ.getTime());
			if(base2 == null){
				return;
			}
			delete(base2, succ);
			child.setTime(succ.getTime());
			child.setReq_index(succ.getReq_index());
		}
	}

	public void delete(int time) {
		// TODO: Code for delete here.
		if(root == null){
			return;
		}
		else{
			//System.out.println(root);
			//System.out.println(time);
			if(time == root.getTime()){
				deleteRoot();
				return;
			}
			Node base = find(root, time);
			if(base != null){
				Node child = null;
				if(base.getRight() == null){
					child = base.getLeft();
				}
				else if(base.getRight().getTime() == time){
					child = base.getRight();
				}else{
					child = base.getLeft();
				}
				delete(base, child);
			}
		}
	}

	/**
		Prints the contents of the tree in sorted order.
	**/
	private void print(Node current){
		if(current != null){
			print(current.getLeft());
			System.out.println(current.getTime());
			print(current.getRight());
		}else{
			return;
		}
	}

	public void print() {
		// TODO: Code for print here.
		print(root);
	}


    public boolean isValidRequest(int time, int k) {
        if (root == null){
		return true;
	}
        return isVR(root, time, k);
    }

    private boolean isVR(Node current, int time, int k) {
        if (current == null) {
            return true;
        }
        if (Math.abs(current.getTime() - time) < k) {
            return false;
        }       
        if (current.getTime() > time) {
            return isVR(current.getLeft(), time, k);
        }
        if (current.getTime() < time) {
            return isVR(current.getRight(), time, k);
        }
        return false;
    }
}

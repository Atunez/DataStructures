
public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 0;
	}

	private int getPI(int i) {
		return i / 2;
	}

	private int getLCI(int i) {
		return 2 * i;
	}

	private int getRCI(int i) {
		return 2 * i + 1;
	}

	private void swap(int p1, int p2){
		Interval temp = heap[p1];
		heap[p1] = heap[p2];
		heap[p2] = temp;
	}

	private void siftDown(int index){
		int largest;
		int leftchild = getLCI(index);
		int rightchild = getRCI(index);
		

		if(leftchild >= numElements && rightchild >= numElements){
			return;
		}else if(leftchild >= numElements && rightchild <= numElements){
			largest = rightchild;
		}else if(leftchild <= numElements && rightchild >= numElements){
			largest = leftchild;
		}else{
			if( heap[leftchild].compareTo(heap[rightchild]) > 0){
				largest = leftchild;
			}else{
				largest = rightchild;
			}
		}

		swap(index, largest);
		siftDown(largest);
	}

	private void siftUp(int index){
		int parent = getPI(index);
		Interval st = heap[index];
		Interval end = heap[parent];
		
		if( end != null && st.compareTo(end) > 0){
			swap(index, parent);
			siftUp(parent);
		}

	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	TODO: Please complete this method.
	*/
	public void insert(Interval k) {
		if (numElements == size) {
			// Expand the buffer allocated for the heap to another buffer that is twice as big.
			Interval[] temp = new Interval[size*2 + 1];
			for(int i = 1; i <= size; i++){
				temp[i] = heap[i];
			}
			heap = temp;
			size *= 2;
		}
		// Insert without buffer expansion here.
		heap[numElements+1] = k;
		numElements++;
		siftUp(numElements);

	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	TODO: Please complete this method.
	*/
	public Interval remove_max() {
		if (numElements == 0) return null; // Retuns null if heap is empty.
		// Remove_max code here.
		
		Interval maximum = heap[1];
		swap(1, numElements);
		numElements--;
		siftDown(1);
		
		return maximum; // Replace this statement with returning the max element (root) in the heap.
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i <= numElements; ++i)
			System.out.println(heap[i]);
	}
}

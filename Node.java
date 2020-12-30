/**
 * Class Node. Represents a single node in the linked list.
 * Each node only contains an integer digit and a next reference.
 **/
public class Node {
	public int digit;
	public Node next;

	public Node(int d, Node n) {
		digit = d;
		next = n;
	}
}

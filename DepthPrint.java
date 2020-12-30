
public class DepthPrint {

	public static void main(String [] args) {
        // Create an instance of MyTree.		
        MyTree T = new MyTree();

        // Get the root node of my tree.
		TreeNode root = T.getRoot();


		// TODO: Code for printing the tree from depth 500 through 510 in sorted order.
		// Feel free to define recursive methods to traverse the tree and print.
		// Please print each key separated by spaces.
		visitleft(root, 510, 10);
		visitright(root, 510, 10);

		// Printing a new line in the end.
		System.out.println();
	}

	public static void visitleft(TreeNode root, int num, int length){
		if(num == -1){
			return;
		}else if(num < length+1){
			visitleft(root.left, num-1, length);
			System.out.print(root.key + " ");
		}else{
			visitleft(root.left, num-1, length);
		}
	}
	
	public static void visitright(TreeNode root, int num, int length){
		if(num == -1){
			return;
		}else if(num < length+1){
			System.out.print(root.key + " ");
			visitright(root.right, num-1, length);
		}else{
			visitright(root.right, num-1, length);
		}
	}
}

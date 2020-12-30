
public class MyTree
{
    private TreeNode root;
    
    private TreeNode insert(final TreeNode treeNode, final int n) {
        if (treeNode == null) {
            return new TreeNode(n);
        }
        if (n <= treeNode.key) {
            treeNode.left = this.insert(treeNode.left, n);
        }
        else {
            treeNode.right = this.insert(treeNode.right, n);
        }
        return treeNode;
    }
    
    public MyTree() {
        this.root = null;
        System.out.println("Loading my Tree.");
        for (int i = 0; i < 10000; ++i) {
            if ((i & 0x1) == 0x1) {
                this.root = this.insert(this.root, -i);
            }
            else {
                this.root = this.insert(this.root, i);
            }
        }
        System.out.println("My Tree is loaded.");
    }
    
    public TreeNode getRoot() {
        return this.root;
    }
}
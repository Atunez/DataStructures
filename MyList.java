public class MyList
{
    private ListNode head;
    
    MyList() {
        System.out.println("Loading my list.");
        for (int i = 0; i < 50000; ++i) {
            this.head = new ListNode(200000 - i, this.head);
        }
        this.head = new ListNode(17, this.head);
        for (int j = 50000; j < 100000; ++j) {
            this.head = new ListNode(200000 - j, this.head);
        }
        System.out.println("My list is successfully loaded. Please print the smallest element.");
    }
    
    public ListNode getHead() {
        return this.head;
    }
}
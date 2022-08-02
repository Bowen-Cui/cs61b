public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int n) {
        val = n;
    }

    ListNode(int n, ListNode next) {
        val = n;
        this.next = next;
    }

    public void print() {
        System.out.print(val + " ");
        if (next != null) {
            next.print();
        } else {
            System.out.println();
        }
    }
}
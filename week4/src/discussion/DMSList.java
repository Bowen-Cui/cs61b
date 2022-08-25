package discussion;

public class DMSList {
    /**Modify the code below so that the max method of DMSList works properly. Assume all numbers inserted into DMSList are positive, and we only insert using
    insertFront. You may not change anything in the given code. You may only fill
    in blanks. You may not need all blanks. (discussion 06 Inheritance and Implements Exam Prep)*/
    private IntNode sentinel;
    public DMSList() {
        sentinel = new IntNode(-1000, new LastIntNode());
    }

    private class IntNode {
        int item;
        IntNode next;
        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }
        public int max(){
           /* if (next==null) {
                return item;
            }*/
            return Math.max(item, next.max());
            /** 最后一个Node的next是null时出错，所以要重写最后一个Node的 max() 方法*/
        }
    }
    public class LastIntNode extends IntNode {
        public LastIntNode(){
            super(0,null);
        }
        @Override
        public int max(){
            return 0;
        }
        /**到了最后一个Node，返回 0 */
    }
    public IntNode putLastNode(int i) {
        return new IntNode(i,null);
    }
    /** Returns 0 if list is empty. Otherwise, returns the max element. */
    public int max(){
        return sentinel.next.max();
    }
    public void insertFront(int x) { sentinel.next = new IntNode(x, sentinel.next); }

    public static void main(String[] args) {
        DMSList lst = new DMSList();
        System.out.println(lst.max());
        lst.insertFront(1);
        System.out.println(lst.max());
    }

}


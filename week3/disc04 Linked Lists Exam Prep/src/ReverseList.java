public class ReverseList {


    public static ListNode reverseList(ListNode head){
   /*     if(head==null) return null;
        ListNode currFirst=head;
        while(head.next!=null){
            ListNode nextFirst=head.next;
            ListNode rest=head.next.next;
            nextFirst.next = currFirst;
            head.next = rest;
            currFirst = nextFirst;
        }
        return currFirst;*/
        ListNode reversedList=null;
        while(head != null){
            ListNode restList = head.next;
            head.next = reversedList;
            reversedList = head;
            head = restList;
        }
        return reversedList;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right){
       ListNode sentinel = new ListNode(-1,head);
       ListNode pre = sentinel;
       for(int i=0; i<left-1; i++){  -1,  1,2,3,4
           pre = pre.next;
       }
       ListNode reversedList = null;
       for(int i=0; i<right-left; i++){
           ListNode curr = pre.next;
           curr.next = curr.next.next;
           pre.next=pre.next.next;
           pre.next.next
       }

        /*if(head.next==null || left==right) return head;
        ListNode leftLast=head;
        int index=1;
        while (index < left-1){
            leftLast = leftLast.next;
            index += 1;
        }
        ListNode leftHead;
        if(left==1){
             leftHead = head;
        } else {
             leftHead = leftLast.next;
        }
        ListNode rightTail=leftLast;
        while(index < right){
            rightTail = rightTail.next;
            index += 1;
        }
        ListNode rightFirst=rightTail.next;
        rightTail.next = null;
        ListNode reversedList = reverseList(leftHead);
        leftHead.next = rightFirst;
        if(left==1){
            return reversedList;
        }
        leftLast.next = reversedList;

        return head;*/
    }


    public static void main(String[] args) {

        ListNode lst = new ListNode (4, null);
         lst = new ListNode (3, lst);
         lst = new ListNode (2, lst);
        lst = new ListNode (1, lst);
         lst.print();
        // reverseList(lst).print();
         reverseBetween(lst, 1,2).print();
    }

}

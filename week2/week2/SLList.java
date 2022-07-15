/**An SLList is a list of integers which hide the truth of the nakedness(nulls).*/
public class SLList {
    /**
     * 为解决首节点为空时无法指向下一个节点的情况，在首节点放任意数值作为哨兵节点(sentinel node)
     * The first item(if it exists) is at sentinel.next */
    private IntNode sentinel;
    private int size;
    /* 嵌套类 Nested Classes*/
    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item=i;
            next=n;
        }
    }

    public SLList(){
        sentinel=new IntNode(100,null);
        size=0;
    }
    public SLList(int x){
        sentinel=new IntNode(100,null);//记得初始化时自动放入哨兵节点
        sentinel.next=new IntNode(x,null);
        size=1;
    }

    /**
     * constructor that takes in an array of integers, and creates an SLList with those integers.
     */
    public SLList(int[] array){
        sentinel=new IntNode(100,null);
        IntNode temp=sentinel;
        for(int i=0;i<array.length;i++){
            temp.next=new IntNode(array[i],null);
            size+=1;
            temp=temp.next;
        }
    }
    /**两个链表相加, 满10进位*/
    public static SLList addTwoNumbers(SLList l1,SLList l2){
        SLList l=new SLList();
        int carryover=0;
        while(l1.sentinel.next!=null || l2.sentinel.next!=null){
            int i= carryover+l1.getFirst() + l2.getFirst();
            if(i>9){
                carryover = 1;
                i=i%10;
            }else{
                carryover=0;
            }
            l.addLast(i);
            if(l1.sentinel.next!=null) l1.sentinel.next=l1.sentinel.next.next;
            if(l1.sentinel.next!=null) l2.sentinel.next=l2.sentinel.next.next;
        }
        if(carryover==1){
            l.addLast(1);
        }
        return l;
    }
    /** Adds f to the front of the List*/
    public void addFirst(int f){
        sentinel.next=new IntNode(f,sentinel.next);
        size+=1;
    }
    /** Returns the first letter in the list*/
    public int getFirst(){
        if(sentinel.next==null){
            //System.out.println("List为空");
            return 0;
        }
        return sentinel.next.item;
    }
    public void deleteFirst(){
        sentinel.next=sentinel.next.next;
        size-=1;
    }

    public void addLast(int x){
        IntNode temp=sentinel;
        /**指针变量temp*/
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new IntNode(x,null);
        size+=1;
    }

    /**
     * A helper method that interacts with the underlying naked recursive data structure.
     *一个一个数太慢了，弃用
     * /
    private static int size(IntNode n){
        if(n.next==null){
        return 1;
        }
        return 1+size(n.next);
    }
    /**重载 two methods with the same name but different signatures are overloaded*/
    /**  return size(first); 一个一个数太慢了, 1000,000个数2000秒
     * 因此在类中声明一个size变量，跟踪当前大小，使我们的size方法非常快，无论列表有多大。
     * 这种保存重要数据以加快检索速度的做法有时称为缓存 caching。
     * 当然，它也会减慢我们的addFirst和addLast方法，也会增加我们类的使用内存，但只是微不足道的数量。*/
    public int size(){

        return size;
    }

    /**We want to add a method to IntList so that if 2 numbers in a row are the same, we add them together and
     make one large node. For example:
     1 → 1 → 2 → 3 becomes 2 → 2 → 3 which becomes 4 → 3
     */
    public void addAdjacent() {
        IntNode temp=sentinel;
        while(temp.next.next!=null){
            int a=temp.next.item;
            int b=temp.next.next.item;
            if(a==b){
                temp.next=new IntNode(a+b,temp.next.next.next);
                size-=1;
                continue;
            }
            temp=temp.next;
        }

    }

    public void printList(){
        if(sentinel.next==null){
            System.out.println("List为空");
            return;
        }
        System.out.print(sentinel.next.item+" ");
        if(sentinel.next.next!=null){
            SLList temp=new SLList();
            temp.sentinel.next=sentinel.next.next;
            temp.printList();}
    }

    public static void main(String[] args) {
        SLList L=new SLList();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        L.deleteFirst();
        L.printList();
        System.out.println();
        System.out.println(L.size());
        System.out.println(L.getFirst());

        SLList A=new SLList();
        A.addLast(10);
        A.deleteFirst();
        A.printList();
        System.out.println(A.size());
        System.out.println(A.getFirst());
        System.out.println();

        int[] array= {1,1,2,4,8};
        SLList B=new SLList(array);
        B.printList();
        System.out.println();
        B.addAdjacent();
        System.out.println(B.size());
        B.printList();
        System.out.println();
        System.out.println();

        int[] array1= {2,4,3,1};
        int[] array2= {5,6,7};
        SLList L1=new SLList(array1);
        SLList L2=new SLList(array2);
        SLList sum = addTwoNumbers(L1,L2);
        sum.printList();



    }
}

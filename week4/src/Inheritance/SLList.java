package Inheritance;

/**An SLList is a list of integers which hide the truth of the nakedness(nulls).*/
public class SLList<T> {
    /**
     * 为解决首节点为空时无法指向下一个节点的情况，在首节点放任意数值作为哨兵节点(sentinel node)
     * The first item(if it exists) is at sentinel.next */
    protected StuffNode sentinel;
    private int size;

    public SLList() {
        sentinel=new StuffNode((T)"a",null);
        size = 0;
    }

    /* 嵌套类 Nested Classes*/
     protected class StuffNode {
        public T item;
        public StuffNode next;
        public StuffNode(T i, StuffNode n){
            item=i;
            next=n;
        }
    }
    public SLList(T x){
        sentinel=new StuffNode(x,null);//记得初始化时自动放入哨兵节点
        sentinel.next=new StuffNode(x,null);
        size=1;
    }

    /**
     * constructor that takes in an array of integers, and creates an SLList with those integers.
     */
/*    public SLList(int[] array){
        sentinel=new StuffNode(100,null);
        StuffNode temp=sentinel;
        for(int i=0;i<array.length;i++){
            temp.next=new StuffNode(array[i],null);
            size+=1;
            temp=temp.next;
        }
    }*/

    public T get(int index){
        if(index>=size || index<0){
            return null;
        }
        int i = 0;
        StuffNode node = sentinel.next;
        while(i<index){
            i += 1;
            node=node.next;
        }
        return (T) node.item;
    }
    /**LEETCODE : 两个链表相加, 满10进位*/
    public static SLList addTwoNumbers(SLList<Integer> l1, SLList<Integer> l2){
        SLList l=new SLList();
        SLList s1=l1;
        SLList s2=l2;
        int carryover=0;
        while(s1.sentinel.next!=null || s2.sentinel.next!=null){
            int i= carryover+(int)s1.getFirst() + (int)s2.getFirst();
            if(i>9){
                carryover = 1;
                i=i%10;
            }else{
                carryover=0;
            }
            l.addLast(i);
            if(s1.sentinel.next!=null) s1.sentinel.next=s1.sentinel.next.next;
            if(s1.sentinel.next!=null) s2.sentinel.next=s2.sentinel.next.next;
        }
        if(carryover==1){
            l.addLast(1);
        }
        return l;
    }

    /** Adds f to the front of the List*/
    public void addFirst(T f){
        sentinel.next=new StuffNode(f,sentinel.next);
        size+=1;
    }

    /** Returns the first letter in the list*/
    public T getFirst(){
        if(sentinel.next==null){
            //System.out.println("List为空");
            return null;
        }
        return sentinel.next.item;
    }

    public void removeFirst(){
        sentinel.next=sentinel.next.next;
        size-=1;
    }
    public T removeLast(){
        StuffNode temp=sentinel;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        T x = temp.next.item;
        temp.next=null;
        size -= 1;
        return x;
    }

    public void addLast(T x){
        StuffNode temp=sentinel;
        /**指针变量temp*/
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new StuffNode(x,null);
        size+=1;
    }

    /**
     * A helper method that interacts with the underlying naked recursive data structure.
     *一个一个数太慢了，弃用
     * /
    private static int size(StuffNode n){
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

/*
    public void addAdjacent() {
        StuffNode temp=sentinel;
        while(temp.next.next!=null){
            int a= (int) temp.next.item;
            int b= (int) temp.next.next.item;
            if(a==b){
                temp.next=new StuffNode(a+b,temp.next.next.next);
                size-=1;
                continue;
            }
            temp=temp.next;
        }
    }
*/

    /**
     * the methods findFirst and findFirstHelper below return the
     * index of the first Node with item n, or -1 if there is no such node containing that item.
     */
    public int findFirst(T n){
        return findFirstHelper(n,0 , sentinel.next);
    }
    public int findFirstHelper(T n, int index, StuffNode curr ){
        if(curr==null){
            return -1;
        }
        if (curr.item==n){
            return index;
        }else{
            return findFirstHelper(n,index+1,curr.next);
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
        L.removeFirst();
        L.printList();
        System.out.println();
        System.out.println(L.size());
        System.out.println(L.getFirst());
/**Test addLast(n),deleteFirst(),size() 和 getFirst() methods*/
        SLList A=new SLList();
        A.addLast(10);
        A.removeFirst();
        A.printList();
        System.out.println(A.size());
        System.out.println(A.getFirst());
        System.out.println();
/**Test array构造方法 和 get(), addAdjacent() method*/
        int[] array= {1,1,2,4,8};
        SLList B=new SLList(array);
        B.printList();
        System.out.println();

        System.out.println(B.get(0));
        System.out.println(B.get(1));
        System.out.println(B.get(2));
        System.out.println(B.get(3));
        System.out.println(B.get(4));

        //B.addAdjacent();
        System.out.println(B.size());
        B.printList();
        System.out.println();
        System.out.println();
/**Test array构造方法 和 addTwoNumbers method*/
        int[] array1= {2,4,3,1};
        int[] array2= {5,6,7};
        SLList L1=new SLList(array1);
        SLList L2=new SLList(array2);
        SLList sum = addTwoNumbers(L1,L2);
        sum.printList();
        System.out.println();
        System.out.println();
/**Test findFirst method*/
        System.out.println(sum.findFirst(2));
        System.out.println(L1.findFirst(1));
        L1.printList();
    }
}

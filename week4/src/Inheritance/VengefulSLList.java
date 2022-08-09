package Inheritance;

public class VengefulSLList<T> extends SLList<T>{
    SLList<T> deletedItems;

    public VengefulSLList() {
        this.deletedItems = new SLList<>();
    }


    public void printDeleted(){
        deletedItems.printList();
    }
    @Override
    public T removeLast(){
        T x =  super.removeLast();//调用父类的remove方法
        deletedItems.addLast(x);//把删除的数加到deletedItems里
        return x;
    }

    public void printLostItems(){
        deletedItems.printList();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> lst = new VengefulSLList<>();
        //通过父类SLList构造器生成有sentinel的list， 通过子类构造器生成deletedItems的list
        lst.printLostItems();
        lst.addFirst(1);
        lst.addLast(2);
        lst.addLast(3);
        //有sentinel的list is now： [1,2,3]
        lst.removeLast();
        //做override的removeLast方法， 有sentinel的list is now：[1,2]
        //并且deletedItems的list is now：[3]
        lst.printList();
        //print父类的有sentinel的list
        System.out.println();
        lst.printLostItems();
        //print子类的deletedItems的list

        SLList<Integer> slList = new VengefulSLList<>();
       // slList.printLostItems(); !!compile time error!!
    }
}

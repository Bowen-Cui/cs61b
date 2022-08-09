package Inheritance;

public class RotatingSLList<T> extends SLList<T>{

    public void rotateRight(){
        T x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rlst = new RotatingSLList<>();
        rlst.addLast(1);
        rlst.addLast(2);
        rlst.addLast(3);
        rlst.addLast(4);
        rlst.rotateRight();
        rlst.printList();
        System.out.println();
        rlst.rotateRight();
        rlst.printList();
    }


}

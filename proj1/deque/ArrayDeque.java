package deque;

public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = array.length-1;
        nextLast = 0;
    }
    /**A helper method that double the size of the array*/
    private void reSizing() {
        T[] temp = (T[])new Object[array.length*2];
        int l1 = array.length-nextLast;
        int l2 = nextLast;
        System.arraycopy(array,nextLast,temp,0,l1);
        System.arraycopy(array,0,temp,l1, l2);
        array = temp;
        nextFirst = array.length-1;
        nextLast = size;
    }

    /**Adds an item of type T to the front of the deque. You can assume that item is never null.*/
    public void addFirst(T item){
        if(size==array.length) {
            reSizing();
        }
        array[nextFirst] = item;
        size+=1;
        nextFirst -= 1;
    }

    /**Adds an item of type T to the back of the deque. You can assume that item is never null.*/
    public void addLast(T item){
        if(size== array.length) {
            reSizing();
        }
        array[nextLast] = item;
        size+=1;
        nextLast += 1;
    }

    /**Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        if (size==0) {
            return true;
        }
        return false;
    }

    /**Returns the number of items in the deque.*/
    public int size(){
        return size;
    }

    /**Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.*/
    public void printDeque(){
        int index = nextFirst+1;
        for(int i=0; i<size; i++){
            if(index==array.length){
                index = 0;
            }
            System.out.print(array[index]+" ");
            index+=1;
        }
        System.out.println();
    }

    /**Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        if(size==0){
            return null;
        }
        int index = nextFirst+1;
        if(index==array.length){
            index = 0;
        }
        T x=array[index];
        array[index]=null;
        nextFirst=index;
        size -=1;
        return x;
    }

    /**Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast(){
        if(size==0){
            return null;
        }
        int index= nextLast-1;
        if(nextLast==0){
            index = array.length-1;
        }
        T x=array[index];
        array[index]=null;
        nextLast=index;
        size -=1;
        return x;
    }

    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index){
        if(index<0 || index>size-1){
            return null;
        }
        int i = nextFirst+1+index;
        if(i>array.length-1){
            i-=array.length;
        }
        T x=array[i];
        return x;
    }

    /**The Deque objects we’ll make are iterable (i.e. Iterable<T>) so we must provide this method to return an iterator.*/
    // public Iterator<T> iterator(){

    // }
    //private class DequeIterator implements Iterator<T> {


        /**Returns whether or not the parameter o is equal to the Deque. o is considered equal if it is a Deque and if it
     * contains the same contents (as goverened by the generic T’s equals method) in the same order.
     * (ADDED 2/12: You’ll need to use the instance of keywords for this. Read here for more information)*/
    public boolean equals(Object o){
        return false;
    }
}


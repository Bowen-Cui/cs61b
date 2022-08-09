package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = array.length - 1;
        nextLast = 0;
    }

    /**A helper method that change the capacity of the array*/
    private void reSizing(double rate) {
        T[] temp = (T[]) new Object[(int) (array.length * rate)];

        if (nextFirst > nextLast || size == array.length) {
            int l1 = array.length - nextFirst - 1;
            int l2 = size - l1;
            System.arraycopy(array, nextFirst + 1, temp, 0, l1);
            System.arraycopy(array, 0, temp, l1, l2);
        } else {
            System.arraycopy(array, nextFirst + 1, temp, 0, size);
        }

        array = temp;
        nextFirst = array.length - 1;
        nextLast = size;
    }
    /**A helper method that get the nextFirst*/
    private int getNextFirst() {
        if (nextFirst == 0) {
            return array.length - 1;
        } else {
            return nextFirst - 1;
        }
    }
    @Override
    /**Adds an item of type T to the front of the deque. You can assume that item is never null.*/
    public void addFirst(T item) {
        if (size  ==array.length) {
            reSizing(2);
        }
        array[nextFirst] = item;
        size += 1;
        nextFirst = getNextFirst();
    }
    /**A helper method that get the nextLast*/
    private int getNextLast() {
        if (nextLast == array.length - 1) {  //【-----123】的情况，nextlast放在index=0   【12345678】的情况，nextlast
            return 0;
        } else {
            return nextLast + 1;
        }
    }
    @Override
    /**Adds an item of type T to the back of the deque. You can assume that item is never null.*/
    public void addLast(T item) {
        if (size == array.length) {
            reSizing(2);
        }
        array[nextLast] = item;
        size += 1;
        nextLast = getNextLast();
    }
  /*  @Override
    *//**Returns true if deque is empty, false otherwise.*//*
    public boolean isEmpty() {
        if (size==0) {
            return true;
        }
        return false;
    }*/
    @Override
    /**Returns the number of items in the deque.*/
    public int size() {
        return size;
    }
    @Override
    /**Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.*/
    public void printDeque() {
        int index = nextFirst + 1;
        for (int i = 0; i < size; i++) {
            if (index == array.length) {
                index = 0;
            }
            System.out.print(array[index] + " ");
            index += 1;
        }
        System.out.println();
    }
    /** A helper method that returns the index of the first item*/
    private int firstIndex() {
        if (nextFirst + 1 == array.length) {
            return  0;
        }
        return nextFirst + 1;
    }
    @Override
    /**Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.*/
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size - 1 <= array.length * 0.25 && array.length > 16) {
            reSizing(0.5);
        }
        int index = firstIndex();
        T x = array[index];
        array[index] = null;
        nextFirst = index;
        size -= 1;
        return x;
    }
    /** A helper method that returns the index of the last item*/
    private int lastIndex() {
        if (nextLast == 0) {
            return array.length - 1;
        }
        return nextLast - 1;
    }
    @Override
    /**Removes and returns the item at the back of the deque.If no such item exists,returns null.*/
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size - 1 <= array.length * 0.25 && array.length > 16) {
            reSizing(0.5);
        }
        int index = lastIndex();

        T x = array[index];
        array[index] = null;
        nextLast = index;
        size -= 1;
        return x;
    }
    @Override
    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        int i = nextFirst + 1 + index;
        if (i > array.length - 1) {
            i -= array.length;
        }
        T x = array[i];
        return x;
    }
    private T getLast() {
        int index = lastIndex();
        return array[index];
    }

    /**The Deque objects we’ll make are iterable (i.e. Iterable<T>)
     * so we must provide this method to return an iterator.*/
    public Iterator<T> iterator() {
        return new DequeIterator();
    }
    private class DequeIterator<T> implements Iterator<T> {
        private int index;
        public DequeIterator(){
             index = 0;
         }
        @Override
        public boolean hasNext() {
                 return index < size;
             }
        @Override
        public T next() {
            T returnItem = (T) get(index);
            index += 1;
            return returnItem;
        }

    }
     /**Returns whether or not the parameter o is equal to the Deque. o is considered equal
      * if it is a Deque and if it contains the same contents (as goverened by the generic T’s
      * equals method) in the same order.(ADDED 2/12: You’ll need to use the instance of keywords
      * for this. Read here for more information)*/
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        if (((Deque<T>) o).size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++){
            if (get(i) != ((Deque<T>) o).get(i)) {
                return false;
            }
        }
        return true;
    }

}


package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private Node sentinel;
    private int size;
    private class Node {
        T item;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /**无参构造，生成首尾相接的list*/
    public LinkedListDeque(){
        sentinel = new Node();
        sentinel.next = sentinel.prev = sentinel;  //important!! make the loop and make no nulls.
        size = 0;
    }

    public LinkedListDeque(T i){
        sentinel = new Node();
        sentinel.next = sentinel.prev = new Node(i,sentinel,sentinel);
        size = 1;
    }
    @Override
    /**Adds an item of type T to the front of the deque. You can assume that item is never null.*/
    public void addFirst(T item){
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }
    @Override
    /**Adds an item of type T to the back of the deque. You can assume that item is never null.*/
    public void addLast(T item){
        sentinel.prev = new Node(item,sentinel.prev,sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }
   /* @Override
    *//**Returns true if deque is empty, false otherwise.*//*
    public boolean isEmpty() {
        if (size==0) {
            return true;
        }
        return false;
    }*/
    @Override
    /**Returns the number of items in the deque.*/
    public int size(){
        return size;
    }
    @Override
    /**Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.*/
    public void printDeque(){
        Node temp = sentinel;
        for(int i=0; i<size; i++){
            System.out.print(temp.next.item+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    @Override
    /**Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        if(size == 0){
            return null;
        }
        T x = sentinel.next.item;
        sentinel.next = sentinel.next.next;//move the second item to the first
        sentinel.next.prev = sentinel;//link this item's previous node to sentinel
        size -= 1;
        return x;
    }
    @Override
    /**Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast(){
        if(size==0){
            return null;
        }
        T x = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return x;
    }
    public T getLast(){
        return sentinel.prev.item;
    }
    @Override
    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index){
        if(index>=size || index<0 ) {
            return null;
        }
        Node n=sentinel;
        if(index<(size/2)){
            for(int cnt=0; cnt<=index; cnt++){
                n = n.next;
            }
        }else{
            for(int cnt=size-1; cnt>=index; cnt--){
                n = n.prev;
            }
        }
        return n.item;
    }

    /**Same as get, but uses recursion.*/
    public T getRecursive(int index){
        if(index>=size || index<0 ) {
            return null;
        }
        Node n=sentinel.next;

        return getRecursiveHelp(index, n);
    }
    public T getRecursiveHelp(int index, Node n){
        if(index==0){
            return n.item;
        }
        return getRecursiveHelp(index-1, n.next);
    }

    /**The Deque objects we’ll make are iterable (i.e. Iterable<T>) so we must provide this method to return an iterator.*/
    public Iterator<T> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator<T> implements Iterator<T>{
        private int index;
        public DequeIterator(){
            index = 0;
        }
        public boolean hasNext(){
            return index<size;
        }
        public T next(){
            T returnItem = (T) get(index);
            index += 1;
            return returnItem;
        }
    }

    /**Returns whether or not the parameter o is equal to the Deque. o is considered equal if it is a Deque and if it
     * contains the same contents (as goverened by the generic T’s equals method) in the same order.
     * (ADDED 2/12: You’ll need to use the instance of keywords for this. Read here for more information)*/
    public boolean equals(Object o){
        try{
            Deque x = (Deque) o;
        }catch(Exception ClassCastException){
            return false;
        }
        for(int i=0; i<size; i++){
            if(get(i) != ((Deque<T>) o).get(i)){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        for(int i : a){
            System.out.println(i);
        }

        ArrayDeque b = new ArrayDeque();
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        b.addLast(4);
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));

        Object c= 10;
        System.out.println(a.equals(c));

        Iterator t = a.iterator();
        while (t.hasNext()){
            System.out.println(t.next());
        }
   }

}

package Set;

import java.util.*;

public class ArraySet<T> implements Iterable<T> {

    private int size;
    private T[] set;
    public ArraySet() {
        set =(T[]) new Object[100];
        size=0;
    }

    public static <T> ArraySet <T> of(T...stuff){
        ArraySet<T> set = new ArraySet<T>();
        for(T i : stuff){
            set.add(i);
        }
        return set;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i=0; i<size; i++){
            if(set[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if(x==null){
            throw new IllegalArgumentException("You cannot add a null to an ArraySet");
        }
        if(this.contains(x)) return;
        set[size]=x;
        size += 1;
        return;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<size-1; i++){
            sb.append(set[i]);
            sb.append(", ");
        }
        sb.append(set[size-1]);
        sb.append("]");
        return sb.toString();
    }

    public String toString2(){
        List<String> list = new ArrayList<>();
        for(T i : this){
            /**!!!注意！这里要用this，不能用set。因为this是ArraySet,有Iterator,支持foreach循环，并且可以判断是否hasNext。用set会遍历全部100位,null异常*/
            list.add(i.toString());
        }
        return String.join(", ", list);
    }

    public Iterator iterator(){
        return new SetIterator();
    }
    private class SetIterator<T> implements Iterator<T>{
        private int wizPos;
        public SetIterator(){
            wizPos = 0;
        }
        @Override
        public boolean hasNext(){
            return wizPos<size;
        }
        @Override
        public T next(){
            T item =(T) set[wizPos];
            wizPos += 1;
            return item;
        }
    }

    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o==this){
            return true;
        }
        if(o.getClass() != this.getClass()){
            return false;
        }
        ArraySet oo = (ArraySet) o;
        if(oo.size() != size){
            return false;
        }
        for(T i : this){
            if(! oo.contains(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<String>();
        try{
            s.add(null);
        }catch(Exception e){
            System.out.println("exception catch");
        }
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());

        ArraySet<Integer> ss = new ArraySet<Integer>();
        ArraySet<Integer> ss2 = ArraySet.of(1,2);
        ss.add(1);
        ss.add(2);
        ss.add(1);
        ss.add(1);
        ss.add(2);
        System.out.println(ss.contains(3));
        System.out.println(ss.size());
        System.out.println();
        System.out.println(ss.equals(ss2));
        System.out.println(ss.equals(null));
        System.out.println(ss.equals(1));

        Set<String> sss = new HashSet<>();
        sss.add(null);
        System.out.println(sss.contains(null));

        System.out.println(s.toString());
        System.out.println(ss.toString());
        System.out.println(s.toString2());

        for(String i:s){
            System.out.println(i);
        }

        for(int i : ss){
            System.out.println(i);
        }


    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}


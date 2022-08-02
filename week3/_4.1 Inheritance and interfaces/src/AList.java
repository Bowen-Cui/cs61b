
public class AList<T> implements List61B<T> {
    /** Array based list.
     *  @author Josh Hug
     */

        private T[] array;
        private int size;


    /**AList Invariants

     1.addLast: The next item we want to add, will go into position size.
     2.getLast: The item we want to return is in position size - 1.
     3.size: The number of items in the list should be size.*/

        //AList next;
        /** Creates an empty list. */
        public AList() {
          array = (T[])new Object[100];
          size = 0;
        }
        /** Resizes the underlying array to the target capacity */
        private void resize(int capacity){
            T[] a = (T[])new Object[capacity];
            System.arraycopy(array, 0 , a,0, size);
            array = a;
        }
    @Override
        /** Inserts X into the back of the list. */
        public void addLast(T x) {
            if(size==array.length) {
                resize(size*2);
            }
            array[size] = x;
            size+= 1;
        }
    @Override
    /** Inserts X into the front of the list. */
        public void addFirst(T x){
            if(size==0){
                array[0] = x;
                return;
            }
            T[] a = (T[])new Object[size+1];
            System.arraycopy(array, 0 , a,1, size);
            array = a;
            array[0] = x;
        }

        /** Returns the item from the back of the list. */
        public T getLast() {
            return array[size-1];
        }



    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public void deleteFirst() {

    }
    @Override
    /** Gets the ith item in the list (0 is the front). */
        public T get(int i) {
            return array[i];
        }
    @Override
        /** Returns the number of items in the list. */
        public int size() {
            return size;
        }

        /** Deletes item from back of the list and
         * returns deleted item. */
        public T removeLast() {
            T x=getLast();
            size -= 1;
            return x;
        }
    }


public class AList {
    /** Array based list.
     *  @author Josh Hug
     */

        private int[] array;
        private int size;


    /**AList Invariants

     1.addLast: The next item we want to add, will go into position size.
     2.getLast: The item we want to return is in position size - 1.
     3.size: The number of items in the list should be size.*/

        //AList next;
        /** Creates an empty list. */
        public AList() {
          array = new int[100];
          size = 0;
        }
        /** Resizes the underlying array to the target capacity */
        private void resize(int capacity){
            int[] a = new int[capacity];
            System.arraycopy(array, 0 , a,0, size);
            array = a;
        }

        /** Inserts X into the back of the list. */
        public void addLast(int x) {
            if(size==array.length) {
                resize(size*2);
            }
            array[size] = x;
            size+= 1;
        }
    /** Inserts X into the front of the list. */
        public void addFirst(int x){
            if(size==0){
                array[0] = x;
                return;
            }
            int[] a = new int[size+1];
            System.arraycopy(array, 0 , a,1, size);
            array = a;
            array[0] = x;
        }

        /** Returns the item from the back of the list. */
        public int getLast() {
            return array[size-1];
        }
        /** Gets the ith item in the list (0 is the front). */
        public int get(int i) {
            return array[i];
        }

        /** Returns the number of items in the list. */
        public int size() {
            return size;
        }

        /** Deletes item from back of the list and
         * returns deleted item. */
        public int removeLast() {
            int x=getLast();
            size -= 1;
            return x;
        }
    }

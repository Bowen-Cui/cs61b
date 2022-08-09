package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        ArrayDeque<Integer> K = new ArrayDeque<>();

        int N = 500000;
        for(int i=0; i<N; i++){
            int operationNumber = StdRandom.uniform(0,5);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                K.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = K.size();
                System.out.println("Correct size: " + size1 + "  Broken size: "+ size2);
                assertEquals(size1, size2);
            } else if (operationNumber == 2) {
                if(L.size() == 0){
                    continue;
                }
                /*int last1 = L.getLast();
                int last2 = K.getLast();
                System.out.println("Correct getLast: " + last1 + "  Broken getLast: " + last2);
                assertEquals(last1, last2);*/
            } else if (operationNumber == 3) {
                if(L.size() == 0){
                    continue;
                }
                int remove1 = L.removeLast();
                int remove2 = K.removeLast();
                System.out.println("Correct removeLast: " + remove1 + "  Broken removeLast: "+ remove2);
                assertEquals(remove1, remove2);
            } else if (operationNumber == 4 && L.size()>0) {
                int q = StdRandom.uniform(0,L.size());
                int get1 = L.get(q);
                int get2 = K.get(q);
                assertEquals(get1,get2);
            }
        }
    }
    @Test
    public void dequeueEnqueueTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        ArrayDeque<Integer> K = new ArrayDeque<>();

        int N = 500000;
        for(int i=0; i<N; i++){
            int operationNumber = StdRandom.uniform(0,2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
              //  L.addLast(randVal);
                K.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                if(K.size() == 0){
                    continue;
                }
               // int remove1 = L.removeLast();
                int remove2 = K.removeFirst();
               // assertEquals(remove1, remove2);
                System.out.println("  Broken removeFirst: "+ remove2);
                System.out.println(K.size());
            }
        }
    }
    @Test
    public void addTest() {
        ArrayDeque<String> a1 = new ArrayDeque<String>();
        assertTrue("should be empty",a1.isEmpty());
        a1.addFirst("a");
        assertEquals(1,a1.size());
        a1.addFirst("b");
        assertEquals(2,a1.size());
        a1.addFirst("c");
        a1.addFirst("d");
        a1.addFirst("e");
        a1.addFirst("f");
        a1.addFirst("g");
        a1.addFirst("h");
        assertEquals(8,a1.size());
        a1.addFirst("0");
        assertEquals(9,a1.size());
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("0");
        a1.addFirst("1");

        a1.printDeque();
    }

    @Test
    public void removeFirstTest(){
        ArrayDeque<String> a1 = new ArrayDeque<String>();
        a1.addLast("a");
        a1.addLast("b");
        a1.addLast("c");
        a1.addLast("d");
        a1.addLast("e");
        a1.addLast("f");
        a1.addLast("g");
        a1.addLast("h");
        a1.addLast("i");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        System.out.println(a1.removeFirst());
        System.out.println(a1.size());
        a1.printDeque();

        a1.addFirst("1");
        a1.printDeque();
    }

    @Test
    public void removeLastTest(){
        ArrayDeque<String> a1 = new ArrayDeque<String>();
        a1.addLast("a");
        a1.addLast("b");
        a1.addLast("c");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        a1.addLast("d");
        System.out.println(a1.removeLast());
        a1.printDeque();
        a1.addLast("1");
        a1.printDeque();

        ArrayDeque<String> a2 = new ArrayDeque<String>();
        System.out.println(a2.removeLast());
        a2.addFirst("99");
        System.out.println(a2.removeLast());
        a2.printDeque();
    }

    @Test
    public void getTest(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addFirst(0);
        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addLast(5);
        lld1.addLast(6);
        int i=lld1.get(0);
        String errorMsg = " actual item: " + i ;
        assertEquals(errorMsg, 0, i);

        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addFirst(15);
        a.addFirst(10);
        a.addFirst(5);
        a.addLast(20);
        int q=a.get(3);
        a.printDeque();
        assertEquals(20, q);
    }
    @Test
    public void multipleParamTest() {
        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }
@Test
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }
}

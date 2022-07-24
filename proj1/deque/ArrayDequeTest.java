package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
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
        a1.addLast("0");
        assertEquals(9,a1.size());
        a1.printDeque();
    }

    @Test
    public void removeFirstTest(){
        ArrayDeque<String> a1 = new ArrayDeque<String>();
        a1.addLast("a");
        a1.addLast("b");
        a1.addLast("c");
        a1.addLast("d");
        System.out.println(a1.removeFirst());
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
}

package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  AListNoResizing<Integer> a = new AListNoResizing<>();
    BuggyAList<Integer> b = new BuggyAList<>();
    @Test
    public void testThreeAddThreeRemove(){
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);

        b.addLast(4);
        b.addLast(5);
        b.addLast(6);

        assertEquals(a.size(), b.size());
        assertEquals(a.removeLast(),b.removeLast());
        assertEquals(a.removeLast(),b.removeLast());
        assertEquals(a.removeLast(),b.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> K = new BuggyAList<>();

        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                K.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = K.size();
                //System.out.println("Correct size: " + size1 + "  Broken size: "+ size2);
                assertEquals(size1, size2);
            } else if (operationNumber == 2) {
                if(L.size() == 0){
                    continue;
                }
                int last1 = L.getLast();
                int last2 = K.getLast();
                //System.out.println("Correct getLast: " + last1 + "  Broken getLast: " + last2);
                assertEquals(last1, last2);
            } else if (operationNumber == 3) {
                if(L.size() == 0){
                    continue;
                }
                int remove1 = L.removeLast();
                int remove2 = K.removeLast();
                //System.out.println("Correct removeLast: " + remove1 + "  Broken removeLast: "+ remove2);
                assertEquals(remove1, remove2);
            }
        }
    }


}

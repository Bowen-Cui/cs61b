import org.junit.Test;
import static org.junit.Assert.*;

public class SortTest {
    /**
     * @org.junit.Test can run the tests separately
     * !!Change each test method to be non-static!!
     * Remove our main method from the TestSort class.
     * No need to manually invoke tests.
     * All tests are run, not just the ones we specify.
     * If one test fails, the others still run.
     * A count of how many tests were run and how many passed is provided.
     * The error messages on a test failure are much nicer looking.
     * If all tests pass, we get a nice message and a green bar appears, rather than simply getting no output.
     */
    @Test
    public void testSort(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);

        /**
         * 用jnuit库测试
         * The org.junit library provides a number of helpful methods
         * and useful capabilities for simplifying the writing of tests.
         */
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSmallest(){
        String[] input = {"i", "have", "an", "egg"};
        int actual=Sort.findSmallest(input,0);
        int expected=2;
        assertEquals(expected, actual);

    }

}

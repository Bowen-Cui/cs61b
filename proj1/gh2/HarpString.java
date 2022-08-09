package gh2;

// TODO: uncomment the following import once you're ready to start this portion
import deque.ArrayDeque;
import deque.Deque;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdAudio;

// TODO: maybe more imports

//Note: This file will not compile until you complete the Deque implementations
public class HarpString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .998; // energy decay factor

    /* Buffer for storing sound data. */
     private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public HarpString(double frequency) {
        int capacity = (int) Math.round(SR/frequency);
        buffer = new ArrayDeque<>();
        for (int i = 0; i < capacity; i += 1) {
            buffer.addLast( 0.0);
        }
        System.out.println("frequency:" + frequency  +"  capacity:" + capacity);
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < buffer.size(); i += 1) {
             buffer.removeFirst();           //Dequeue from head
             buffer.addLast(Math.random() + 1);    //enqueue from tail
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double a = buffer.removeFirst();
        double b = buffer.get(0);
        int random = StdRandom.uniform(0,2);
        //System.out.println(random);
        //if(random==0){
       //     buffer.addLast((a+b)/2*DECAY );
       // } else {
            buffer.addLast((a + b)/2 * DECAY );
        }
            //System.out.println(buffer.get(0));
   // }

    /* Return the double at the front of the buffer. */
    public double sample() {
        if (buffer.isEmpty()) {
            return 0;
        }
        return buffer.get(0);
    }

    public static void main(String[] args) {
        HarpString aString = new HarpString(440);
        aString.pluck();
        for (int i = 0; i < 50000; i += 1) {
            StdAudio.play(aString.sample());
            aString.tic();
        }
    }
}

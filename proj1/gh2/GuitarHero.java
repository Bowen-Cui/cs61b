package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {


    //public static final double CONCERT_A = 440.0;
    // public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    public static final int KEYNUM = 37;
    public static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static double setFrequency(int i) {
        //System.out.println(440.0 * Math.pow(2.0, (i - 24.0) / 12.0));
        return 440.0 * Math.pow(2.0, (i - 24.0) / 12.0);
    }

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        //GuitarString stringA = new GuitarString(CONCERT_A);
        //GuitarString stringC = new GuitarString(CONCERT_C);
        /**
         * Create an array of 37 GuitarStrings with frequency from 110HZ to 880HZ
         */
        GuitarString[] notes = new GuitarString[KEYNUM];
        for (int i = 0; i < KEYNUM; i += 1) {
            notes[i] = new GuitarString(setFrequency(i));
        }

        while (true) {
             //check if the user has typed a key; if so, process it
  /*          int random = StdRandom.uniform(0,KEYNUM);

            Notes[random].pluck();
            for (int i = 0; i < 10000; i += 1) {
                edu.princeton.cs.introcs.StdAudio.play(Notes[random].sample());
                Notes[random].tic();
            }*/
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = KEYBOARD.indexOf(key);
                System.out.println(i);
                if (i != -1) {
                    notes[i].pluck();
                }
            }
            double sample = 0.0;
            for (int i = 0; i < KEYNUM; i += 1) {
                sample += notes[i].sample();
                notes[i].tic();
            }
            StdAudio.play(sample);
        }
    }
}


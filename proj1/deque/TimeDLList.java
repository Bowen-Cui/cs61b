package deque;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeDLList {
    private static void printTimingTable(AList<Integer> ns,
                                         AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < ns.size(); i += 1) {
            int N = ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        //  YOUR CODE HERE

        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int i = 1000; i <= 128000; i *= 2) {
            LinkedListDeque<Integer> lst = new LinkedListDeque<>();
            for (int n = 0; n < i; n++) {
                lst.addLast(1);
            }
            Stopwatch sw = new Stopwatch();
            for (int n = 0; n < 10000; n++) {
                lst.get(i);
            }
            double time = sw.elapsedTime();
            ns.addLast(i);
            times.addLast(time);
            opCounts.addLast(10000);
        }
        printTimingTable(ns, times, opCounts);
    }
}

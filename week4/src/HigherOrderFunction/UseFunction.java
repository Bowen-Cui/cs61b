package HigherOrderFunction;

public class UseFunction {
    public static int doTwice(IntFunction f, int x){
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        IntFunction f = new TenX();
        int result=doTwice(f, 5);
        System.out.println(result);

        IntFunction f2 = new SquareX();
        int result2 = doTwice(f2, 10);
        System.out.println(result2);

    }
}

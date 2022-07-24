public class Xor {

    public static void main(String[] args) {
        boolean a=true;
        boolean b=false;

        int m=1;
        int n=0;

        int x=2;
        int y=4;

        System.out.print(a^a);
        System.out.println(m^m);

        System.out.print(b^b);
        System.out.println(n^n);

        System.out.print(a^b);
        System.out.println(m^n);

        System.out.println(x^x);
        System.out.println(y^y);
        System.out.println(m^x);
        System.out.println(m^y);
        System.out.println(x^y);

        /**
         * Xor逻辑运算：^
         * 判定，同真同假为flase，两性相异为true
         */
    }
}

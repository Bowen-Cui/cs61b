package DynamicProgramming;

import static java.lang.Integer.MAX_VALUE;

public class CoinChange669 {
    public static int coinChange(int n) {
        // f[x] = min{f[x-2]+1, f[x-5]+1, f[x-7]+1}
        double[] f = new double[n + 1];
        f[0] = 0;
        double a, b, c;
        a = b = c = MAX_VALUE;
        for (int x = 1; x < n + 1; x++) {  //0, 1, 2, 3, ..20,..22,..25,..27
            if (x - 2 >= 0) {
                a = f[x - 2] + 1;
            }
            if (x - 5 >= 0) {
                b = f[x - 5] + 1;
            }
            if (x - 7 >= 0) {
                c = f[x - 7] + 1;
            }
            f[x] = min(a, b, c);
        }
        return (int)f[n];
    }
    private static double min(double a, double b, double c) {
        double min1 = Math.min(a, b);
        return Math.min(min1, c);
    }

    public static int coinChange(int[] coins, int amount) {
        // f[x] = min{f[x-2]+1, f[x-5]+1, f[x-7]+1}
        int[] f = new int[amount + 1];
        int len = coins.length;// number of kinds of coins
        //initialization
        f[0] = 0;
        // f[0],f[1],f[2],...f[20],..f[22],..f[25],..[f[27]
        // coins [2, 5, 7]
        for (int x = 1; x < amount + 1; x++) {
            f[x] = MAX_VALUE;//正无穷代表找不到
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] > 0 && x - coins[i] >= 0 && f[x - coins[i]] != MAX_VALUE) {
                    f[x] = Math.min(f[x], f[x - coins[i]] + 1);
                }
            }
        }
        if (f[amount] == MAX_VALUE) f[amount] = -1;//当找不到时，返回-1
        return f[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2,5,7}, 27));
    }


}

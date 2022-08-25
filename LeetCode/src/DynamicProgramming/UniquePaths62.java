package DynamicProgramming;

public class UniquePaths62 {
    public static int uniquePaths(int m, int n) {
        //f[i][j] = f[i-1][j] + f[i][j-1]
        // corner case
        if (m == 1 || n == 1){
            return 1;
        }
        int[][] f = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }

    public static int uniquePathsBetter(int m, int n) {
        //f[j] = f[j-1] + f[j]
        // corner case
        if (m == 1 || n == 1){
            return 1;
        }
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                    f[j] = f[j-1] + f[j];
            }
        }
        return f[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsBetter(3,3));
    }
}

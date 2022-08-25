package DynamicProgramming;

import static java.lang.Integer.MAX_VALUE;

public class MinimumFallingPathSum931 {
    public static int minFallingPathSum(int[][] matrix) {
        //f[i][j] = matrix[i][j] + min(sum[i-1][j], sum[i-1][j-1], sum[i-1][j+1])
        //f[i][0] = matrix[i][0] + min(sum[i-1][0], sum[i-1][1])
        //f[i][n-1] = matrix[i][n-1] + min(sum[i-1][n-2], sum[i-1][n-1])

        int n = matrix.length;
        //corner case
        if (n == 1) {
            return matrix[0][0];
        }
        int[][] sum = new int[2][n];
        //0  i&1==0
        //1  i&1==1
        int min = MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0) {
                    sum[i & 1][0] = matrix[i][j] + Math.min(sum[(i-1) & 1][0], sum[(i-1) & 1][1]);
                } else if (j == n - 1) {
                    sum[i & 1][j] = matrix[i][j] + Math.min(sum[(i-1) & 1][n-2], sum[(i-1) & 1][n-1]);
                } else {
                    int minHelp = Math.min(sum[(i-1) & 1][j-1], sum[(i-1) & 1][j]);
                    sum[i & 1][j] = matrix[i][j] + Math.min(minHelp, sum[(i-1) & 1][j+1]);
                }
                if (i == n - 1) {
                   // System.out.println(sum[i & 1][j]);
                    min = Math.min(min, sum[i & 1][j]);
                }
            }
        }
        return min;
    }

}

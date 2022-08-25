package DynamicProgramming;

import java.util.Arrays;

public class MinimumFallingPathSumII1289 {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        //corner case
        if (n == 1) {
            return matrix[0][0];
        }
        int sum;
        //0,j  i&1==0
        //1,j  i&1==1
        int[][] min = new int[n][3];
        //i,1 = minIndex
        //i,2 = min
        //i,3 = second min

        for (int j = 0; j < n; ++j) {
            Arrays.fill(min[j], Integer.MAX_VALUE);
            if (matrix[0][j] < min[0][1]) {
                min[0][2]  = min[0][1];
                min[0][1] = matrix[0][j];
                min[0][0] = j;
            } else if (matrix[0][j] < min[0][2] ) {
                min[0][2] = matrix[0][j];
            }
        }
        System.out.println(min[0][0]+" "+min[0][1]+" "+min[0][2]);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j != min[i-1][0]) {
                    sum = matrix[i][j] + min[i-1][1];
                } else {
                    sum= matrix[i][j] + min[i-1][2];
                }
                if (sum < min[i][1]) {
                    min[i][2] = min[i][1];
                    min[i][1] = sum;
                    min[i][0] = j;
                } else if (sum < min[i][2]) {
                    min[i][2] = sum;
                }
            }
            System.out.println(min[i][0]+" "+min[i][1]+" "+min[i][2]);
        }
        return min[n-1][1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        minFallingPathSum(matrix);
    }
}

package DynamicProgramming;

public class uniquePathsWithObstacles63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        } else {
            obstacleGrid[0][0] = 1;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ( i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1]; //第一行，等于左边的数(若前面有障碍则为0)
                } else if(j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j]; //第一列，等于上方的数(若上面有障碍则为0)
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}

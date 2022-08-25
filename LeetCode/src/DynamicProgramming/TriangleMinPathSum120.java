package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;

public class TriangleMinPathSum120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        /**转换方程重点！！因为 f(n)是一维数组，所以要看清楚当前行是看 triangle的，上一行是看 f(n)的（做过sum的）*/
        //f[i][j] = triangle(i,j) + min(f[j-1], f[j])
        //f[0] = f[0] + triangle(i,0)
        //f[last] = f[i-1] + triangle(i,j)
        // corner case
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        int min = MAX_VALUE;
        for (int i = 1; i < m; ++i) {
            for (int j = i; j >= 0; --j) { //!!从后往前遍历，先改后面的数，不影响前面的值
                // last == i;这一行最末尾的index就是i（第i行: 0,1..,i）
                if (j == i) {
                    //这一行row最末尾的一个位置，继承上一行前一列front row and front column+当前位置的值
                    f[j] = f[i-1] + triangle.get(i).get(j);
                } else if (j > 0 && j < i) {
                    //这一行row除头尾外中间的位置，继承上一行本列/前一列的最小值+当前位置的值
                    f[j] = Math.min(f[j-1], f[j]) + triangle.get(i).get(j);
                } else if (j == 0) {
                    //这一行第一位，继承上一行第一个数 + 当前位置的值
                    f[j] = f[0] + triangle.get(i).get(j);
                }
                if (i == (m - 1)) {
                    min = Math.min(min, f[j]);
                }
            }
        }
        return min;
    }
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        triangle.add(d);

        System.out.println(minimumTotal(triangle));
    }
}

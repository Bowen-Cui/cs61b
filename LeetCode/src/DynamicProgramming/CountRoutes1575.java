package DynamicProgramming;

import java.util.Arrays;

public class CountRoutes1575 {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        //O(f*n)
        //resultSum = f[1] + f[2] + ... + f[fuel]// 把到达终点的fuel cost=1,2,..fuel的路径个数加起来
        // |loc[i] - loc[finish]| < fuel && |loc[i] - loc[start]|
        //
        // 4f, 3s, 1  fuel= 6
        // 1, x, 2  //cost
        // 5, x, 4  //rest
        //
        // 2, 3s, 6, 8f, 4   fuel = 5
        // 6, 5, 2, 0, 4



        int cnt = 0;
        int n = locations.length;
        int[] restFuel = new int[n];
        Arrays.fill(restFuel, fuel);
        if (Math.abs(locations[start] - locations[finish]) > fuel) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (i == finish) continue;
            int cost1 = Math.abs(locations[i] - locations[finish]);
            int cost2 = Math.abs(locations[i] - locations[start]);
            restFuel[i] -= cost1;
            if (restFuel[i] >= 0 && cost2 <= restFuel[i]) {
                cnt += 1;
            }
            finish = i;
        }




    }
}

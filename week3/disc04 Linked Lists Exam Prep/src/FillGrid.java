public class FillGrid {


    public static void fillGrid(int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int M = S[0].length;
        int kL, kR;
        kL = kR = 0;
        for (int i = 0; i < N; i += 1) {
            for (int m = 0; m < i; m += 1) {
                S[i][m] = LL[kL];
                kL += 1;
            }
            for (int n = i + 1; n < M; n++) {
                S[i][n] = UR[kR];
                kR += 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] LL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0};
        int[] UR = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[][] S = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        fillGrid(LL, UR, S);
        for (int i = 0; i < S.length; i += 1) {
            for (int m = 0; m < S[0].length; m += 1) {
                System.out.print(S[i][m]+", ");
            }
            System.out.println();
        }
    }
}

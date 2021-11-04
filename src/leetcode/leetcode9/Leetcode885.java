package leetcode.leetcode9;

public class Leetcode885 {

    int[][] nextPos=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {

        int[][] res = new int[R*C][2];
        int t = 0;

        res[t++] = new int[]{r0, c0};
        if (R * C == 1)
            return res;

        for (int k = 1; k < 2*(R+C); k += 2)
            for (int i = 0; i < 4; i++) {
                int dk = k + (i / 2);
                for (int j = 0; j < dk; ++j) {
                    r0 += nextPos[i][0];
                    c0 += nextPos[i][1];
                    if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C) {
                        res[t++] = new int[]{r0, c0};
                        if (t == R * C)
                            return res;
                    }
                }
            }

        return res;
    }

}

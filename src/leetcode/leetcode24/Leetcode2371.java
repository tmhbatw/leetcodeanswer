package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2371 {

    public int[][] minScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m * n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                res[i * n + j] = new int[]{grid[i][j], i, j};
        }
        Arrays.sort(res, (o1, o2) -> o1[0] - o2[0]);
        // for(int[] cur:res){
        //     System.out.println(Arrays.toString(cur));
        // }

        int[] mm = new int[m];
        int[] nn = new int[n];

        for (int[] cur : res) {
            int min = Math.max(mm[cur[1]], nn[cur[2]]) + 1;
            mm[cur[1]] = min;
            nn[cur[2]] = min;
            grid[cur[1]][cur[2]] = min;
        }

        return grid;
    }

}

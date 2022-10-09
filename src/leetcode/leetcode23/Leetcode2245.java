package leetcode.leetcode23;

public class Leetcode2245 {

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] col2 = new int[m][n + 1];
        int[][] col5 = new int[m][n + 1];

        int[][] row2 = new int[m + 1][n];
        int[][] row5 = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int time5 = get5(grid[i][j]);
                int time2 = get2(grid[i][j]);

                col2[i][j + 1] = col2[i][j] + time2;
                col5[i][j + 1] = col5[i][j] + time5;
                row2[i + 1][j] = row2[i][j] + time2;
                row5[i + 1][j] = row5[i][j] + time5;
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur2 = row2[i + 1][j] + col2[i][n] - col2[i][j + 1];
                int cur5 = row5[i + 1][j] + col5[i][n] - col5[i][j + 1];
                result = Math.max(result, Math.min(cur2, cur5));

                cur2 = row2[i + 1][j] + col2[i][j];
                cur5 = row5[i + 1][j] + col5[i][j];
                result = Math.max(result, Math.min(cur2, cur5));

                cur2 = row2[m][j] - row2[i][j] + col2[i][j];
                cur5 = row5[m][j] - row5[i][j] + col5[i][j];
                result = Math.max(result, Math.min(cur2, cur5));

                cur2 = row2[m][j] - row2[i][j] + col2[i][n] - col2[i][j + 1];
                cur5 = row5[m][j] - row5[i][j] + col5[i][n] - col5[i][j + 1];
                result = Math.max(result, Math.min(cur2, cur5));
            }
        }

        return result;
    }

    private int get2(int cur) {
        int result = 0;
        while ((cur & 1) == 0) {
            cur <<= 1;
            result++;
        }
        return result;
    }

    private int get5(int cur) {
        int result = 0;
        while (cur % 5 == 0) {
            cur /= 5;
            result++;
        }
        return result;
    }


}

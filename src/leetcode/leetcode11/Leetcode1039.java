package leetcode.leetcode11;

public class Leetcode1039 {

    public int minScoreTriangulation(int[] values) {
        int length = values.length;
        int[][] dp = new int[length][length];

        for (int l = 2; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i + 1; m < j; m++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + values[i] * values[j] * values[m] + dp[m][j]);
                }
            }
        }

        return dp[0][length - 1];
    }

}

package leetcode.leetcode17;

public class Leetcode1692 {

    public int waysToDistribute(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int mod = 1000000007;
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Math.min(i + 1, k); j++) {
                dp[i + 1][j + 1] = (int) (((long) (dp[i][j + 1]) * (j + 1) + dp[i][j]) % mod);
            }
        }

        return dp[n][k];
    }


}

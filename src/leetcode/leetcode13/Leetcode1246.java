package leetcode.leetcode13;

public class Leetcode1246 {

    public int minimumMoves(int[] arr) {
        int length = arr.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++)
            dp[i][i] = 1;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == arr[i + 1])
                dp[i][i + 1] = 1;
            else
                dp[i][i + 1] = 2;
        }

        for (int l = 2; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }

                if (arr[i] == arr[j])
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
            }
        }

        return dp[0][length - 1];
    }


}

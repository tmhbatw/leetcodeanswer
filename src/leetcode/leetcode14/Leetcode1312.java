package leetcode.leetcode14;

public class Leetcode1312 {

    public int minInsertions(String s) {
        int length = s.length();
        if (length == 1)
            return 0;
        int[][] dp = new int[length][length];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 0;
            if (i > 0) {
                dp[i - 1][i] = s.charAt(i) == s.charAt(i - 1) ? 0 : 1;
            }
        }

        for (int l = 2; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][length - 1];
    }


}

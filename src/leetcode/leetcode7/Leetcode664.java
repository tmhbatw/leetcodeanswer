package leetcode.leetcode7;

public class Leetcode664 {

    public int strangePrinter(String s) {
        if (s.length() == 1)
            return 1;

        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++)
            dp[i][i] = 1;
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = 1;
            else
                dp[i][i + 1] = 2;
        }

        for (int l = 2; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;

                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i][j - 1];

                if (s.charAt(i) == s.charAt(i + 1))
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                if (s.charAt(j) == s.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i][j]);

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
            }
        }

        return dp[0][length - 1];
    }


}

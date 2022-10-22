package leetcode.leetcode13;

public class Leetcode1220 {

    public int countVowelPermutation(int n) {
        int[][] dp = new int[n][5];
        /*
         * a  0   e  i  u
         * e  1   a  i
         * i  2   e  o
         * o  3   i
         * u  4   i  o
         *  */
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = 1;

        int mod = 1000000007;
        for (int i = 1; i < n; i++) {
            dp[i][0] = ((dp[i - 1][1] + dp[i - 1][2]) % mod + dp[i - 1][4]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
        }

        long res = 0;
        for (int i = 0; i < 5; i++)
            res += dp[n - 1][i];

        return (int) (res % mod);
    }


}

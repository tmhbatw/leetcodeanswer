package leetcode.leetcode25;

public class Leetcode2466 {


    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int mod = 1000000007;

        for (int i = 0; i <= high; i++) {
            if (i + zero <= high) {
                dp[i + zero] += dp[i];
                dp[i + zero] %= mod;
            }
            if (i + one <= high) {
                dp[i + one] += dp[i];
                dp[i + one] %= mod;
            }
        }

        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % mod;
        }

        return result;
    }


}

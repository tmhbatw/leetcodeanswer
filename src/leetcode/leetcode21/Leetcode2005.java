package leetcode.leetcode21;

public class Leetcode2005 {
    public boolean findGameWinner(int n) {
        if (n == 1)
            return false;
        int[] dp = new int[n];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = 1 + (dp[i - 1] ^ dp[i - 2]);
        }
        return (dp[n - 1] ^ dp[n - 2]) != 0;
    }

}

package leetcode.leetcode25;

public class Leetcode2481 {

    //找到一个时间点，在这个时间之前的N+这个时间点之后的Y最小
    public int bestClosingTime(String customers) {
        int[] dp = new int[customers.length() + 1];
        for (int j = customers.length() - 1; j >= 0; j--) {
            dp[j] = dp[j + 1];
            if (customers.charAt(j) == 'Y') {
                dp[j]++;
            }
        }

        int result = 0;
        int cur = dp[0];
        int curN = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'N') {
                curN++;
            }
            if (curN + dp[i + 1] < cur) {
                cur = curN + dp[i + 1];
                result = i + 1;
            }
        }

        return result;
    }

}

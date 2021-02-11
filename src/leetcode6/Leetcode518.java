package leetcode6;

import java.util.Arrays;

public class Leetcode518 {
    /*Description
    * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
    * 假设每一种面额的硬币有无限个。
     * */

    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        Arrays.sort(coins);
        for(int cur:coins){
            for(int j=cur;j<=amount;j++){
                dp[j]+=dp[j-cur];
            }
        }
        return dp[amount];
    }
}

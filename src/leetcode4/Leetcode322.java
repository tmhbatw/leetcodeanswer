package leetcode4;

public class Leetcode322 {
    /*Description
    * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
    * 如果没有任何一种硬币组合能组成总金额，返回-1。你可以认为每种硬币的数量是无限的。
    * */

    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]>0)
                    dp[j]=Math.min(dp[j]==0?Integer.MAX_VALUE:dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount]-1;
    }
}

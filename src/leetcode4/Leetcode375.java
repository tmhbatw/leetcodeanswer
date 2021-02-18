package leetcode4;

import java.util.Arrays;

public class Leetcode375 {
    /*Description
    * 我们正在玩一个猜数游戏，游戏规则如下：
    * 我从1到 n 之间选择一个数字，你来猜我选了哪个数字。
    * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
    * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
    * */

    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<n;i++)
            dp[i][i+1]=i;
        for(int length=2;length<n;length++){
            for(int i=1;i<=n-length;i++){
                dp[i][i+length]=i+dp[i+1][i+length];
                for(int j=i+1;j<i+length;j++){
                    dp[i][i+length]=Math.min(dp[i][i+length],j+Math.max(dp[i][j-1],dp[j+1][i+length]));
                }
            }
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        return dp[1][n];
    }
}

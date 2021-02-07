package leetcode3;

import java.util.Arrays;

public class Leetcode279 {
    /*Description
    * 给定正整数 n，找到若干个完全平方数（比如1, 4, 9, 16, ...）
    * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
    * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
    * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
    * */

    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++)
            dp[n]=n;
        for(int i=2;i<=Math.sqrt(n);i++){
            for(int j=i*i;j<=n;j++){
                dp[j]=Math.min(dp[j-i*i]+1,dp[j]);
            }
        }
        return dp[n];
    }
}

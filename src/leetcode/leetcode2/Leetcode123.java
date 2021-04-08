package leetcode.leetcode2;

import java.util.Arrays;

public class Leetcode123 {
    /*Description
    * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
    * 注意:你不能同时参与多笔交易（你必须在再次购    买前出售掉之前的股票）。
    * */

    //dp[5][length]分别保存没有操作，买了第一支股票、卖了第一支股票、
    // 买了第二支股票、卖了第二支股票五种状态

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int pLength=prices.length;
        if(pLength==2){
            return Math.max(0,prices[1]-prices[0]);
        }
        if(pLength==3){
            return Math.max(Math.max(0,prices[1]-prices[0]),prices[2]-Math.min(prices[0],prices[1]));
        }
        int[][] dp=new int[5][pLength];
        //初始化这个dp数组
        dp[1][0]=-prices[0];
        for(int j=1;j<4;j++)
            dp[1][j]=Math.max(dp[1][0],-prices[j]);
        dp[2][1]=-prices[0]+prices[1];
        for(int j=2;j<4;j++)
            dp[2][j]=Math.max(dp[2][j-1],dp[1][j-1]+prices[j]);
        dp[3][2]=dp[2][1]-prices[2];
        dp[3][3]=Math.max(dp[3][2],dp[2][2]-prices[3]);
        dp[4][3]=dp[3][2]+prices[3];
        for(int i=4;i<pLength;i++){
            dp[1][i]=Math.max(dp[1][i-1],dp[0][i-1]-prices[i]);
            dp[2][i]=Math.max(dp[2][i-1],dp[1][i-1]+prices[i]);
            dp[3][i]=Math.max(dp[3][i-1],dp[2][i-1]-prices[i]);
            dp[4][i]=Math.max(dp[4][i-1],dp[3][i-1]+prices[i]);
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        return Math.max(0,Math.max(dp[2][pLength-1],dp[4][pLength-1]));
    }
    //保存三个数组，分别用来存储当前持有一支股票、两支股票以及不持有股票的最大值
/*    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int pLength=prices.length;
        int[] buy1=new int[pLength],buy2=new int[pLength],sell=new int[pLength];
        buy2[0]=Integer.MIN_VALUE;
        buy1[0]=-prices[0];
        for(int i=1;i<pLength;i++){
            buy1[i]=Math.max(buy1[i-1],Math.max(sell[i-1]-prices[i],buy2[i-1]+prices[i]));
            sell[i]=Math.max(sell[i-1],buy1[i-1]+prices[i]);
            buy2[i]=Math.max(buy2[i-1],buy1[i-1]-prices[i]);
        }
        System.out.println(Arrays.toString(sell));
        System.out.println(Arrays.toString(sell));
        System.out.println(Arrays.toString(sell));
        return sell[pLength-1];
    }*/
}

package leetcode2;

import java.util.Arrays;

public class Leetcode122 {
    /*Description
    * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
    * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    * */

    //保存两个数组，一个用来存储当天为买状态的最大值，一个用来存储当天为卖状态的最大值，然后
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int pLength=prices.length;
        int[] buy=new int[pLength],sell=new int[pLength];
        buy[0]=-prices[0];
        for(int i=1;i<pLength;i++){
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],sell[i-1]-prices[i]);
        }
        return sell[pLength-1];
    }
}

package leetcode2;

import java.util.Arrays;

public class Leetcode123 {
    /*Description
    * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
    * 注意:你不能同时参与多笔交易（你必须在再次购    买前出售掉之前的股票）。
    * */

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

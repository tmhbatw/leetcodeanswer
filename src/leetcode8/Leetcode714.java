package leetcode8;

public class Leetcode714 {
    /*Description
    * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
    * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
    * 返回获得利润的最大值。
    * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
    * */

    public int maxProfit(int[] prices, int fee) {
        if(prices==null||prices.length<=1)
            return 1;
        int length=prices.length;
        int[] dp1=new int[length];
        int[] dp2=new int[length];
        dp1[0]=-prices[0];
        for(int i=1;i<length;i++){
            dp1[i]=Math.max(dp1[i-1],dp2[i-1]-prices[i]);
            dp2[i]=Math.max(dp2[i-1],dp1[i-1]+prices[i]-fee);
        }
        return dp2[length-1];
    }
}

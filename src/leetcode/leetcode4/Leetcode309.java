package leetcode.leetcode4;

public class Leetcode309 {
    /*Description
    * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
    * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
    * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    * */

    public int maxProfit(int[] prices) {
        int day=prices.length;
        if(day<=1)
            return 0;
        int[] dp1=new int[day];//表示第i天为买入状态的最大值
        int[] dp2=new int[day];//表示第i天为卖出状态，且不是今天卖出的
        int[] dp3=new int[day];//表示第i天为卖出状态，而且是今天卖出的
        dp1[0]=-prices[0];
        for(int i=1;i<day;i++){
            dp1[i]=Math.max(dp1[i-1],dp2[i-1]-prices[i]);
            dp2[i]=Math.max(dp2[i-1],dp3[i-1]);
            dp3[i]=dp1[i-1]+prices[i];
        }
        return Math.max(dp2[day-1],dp3[day-1]);
    }
}

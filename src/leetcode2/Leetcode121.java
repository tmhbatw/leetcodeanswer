package leetcode2;

public class Leetcode121 {
    /*Description
    * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
    * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
    * 注意：你不能在买入股票前卖出股票。
    * */

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int pLength=prices.length;
        int[] max=new int[pLength];
        for(int j=pLength-2;j>=0;j--){
            max[j]=Math.max(max[j+1],prices[j+1]);
        }
        int result=0;
        for(int i=0;i<pLength;i++)
            result=Math.max(result,max[i]-prices[i]);
        return result;
    }
}

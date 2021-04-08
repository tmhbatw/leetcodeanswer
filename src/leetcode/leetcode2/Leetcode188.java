package leetcode.leetcode2;

public class Leetcode188 {
    /*Description
    * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
    * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
    * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    * */

    public int maxProfit(int k, int[] prices) {
        if (prices==null||prices.length<=1||k==0) {
            return 0;
        }
        int length=prices.length;
        k=Math.min(k,length/2);
        int[][] sell=new int[length+1][k+1];
        int[][] buy=new int[length+1][k+1];
        //首先需要赋初始值
        sell[1][1]=-prices[0];
        buy[2][1]=-prices[0]+prices[1];
        for(int j=2;j<=k;j++){
            sell[j*2-1][j]=buy[j*2-2][j-1]-prices[j*2-2];
            buy[j*2][j]=sell[j*2-1][j]+prices[j*2-1];
        }
        for(int j=1;j<=k;j++){
            for(int i=j*2;i<=length;i++){
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] - prices[i-1]);
                if(i!=2*j)
                    buy[i][j]=Math.max(buy[i-1][j],sell[i-1][j]+prices[i-1]);
            }
        }
        int max=0;
        for(int i=0;i<=k;i++)
            max=Math.max(buy[length][i],max);
        return max;
    }

    public  static void main(String[] args){
        int[] num=new int[]{3,2,6,5,0,3};
        int k=2;
        System.out.println(new Leetcode188().maxProfit(k,num));
    }
}

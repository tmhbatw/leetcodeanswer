package forOffer;

public class forOffer63 {
    /*Description
    * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
    * */

    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int min=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            res=Math.max(res,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return res;
    }
}

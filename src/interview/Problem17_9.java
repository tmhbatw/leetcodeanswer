package interview;

public class Problem17_9 {
    /*Description
    * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
    * 而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
    * */

    public int getKthMagicNumber(int k) {
        int num3=3,index3=1;
        int num5=5,index5=1;
        int num7=7,index7=1;
        int[] dp=new int[k];
        dp[0]=1;
        for(int i=1;i<k;i++){
            if(num3<=num5&&num3<=num7){
                dp[i]=num3;
                if(num5==num3){
                    num5=5*dp[index5++];
                }
                if(num7==num3){
                    num7=7*dp[index7++];
                }
                num3=3*dp[index3++];
            }
            else if(num5<=num7){
                dp[i]=num5;
                if(num5==num7){
                    num7=7*dp[index7++];
                }
                num5=5*dp[index5++];
            }
            else{
                dp[i]=num7;
                num7=7*dp[index7++];
            }
        }
        return dp[k-1];
    }
}

package forOffer;

public class forOffer10_1 {
    /*Description
    * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
    * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
    * */

    public int numWays(int n) {
        if(n<=1)
            return 1;
        int mod=1000000007;
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
            dp[i]%=mod;
        }
        return dp[n];
    }
}

package interview;

public class Problem8_11 {
    /*Description
    * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
    * (结果可能会很大，你需要将结果模上1000000007)
    * */

    public int waysToChange(int n) {
        int mod=1000000007;
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=1;
        for(int i=5;i<=n;i++){
            dp[i]+=dp[i-5];
            dp[i]%=mod;
        }
        for(int i=10;i<=n;i++){
            dp[i]+=dp[i-10];
            dp[i]%=mod;
        }
        for(int i=25;i<=n;i++){
            dp[i]+=dp[i-25];
            dp[i]%=mod;
        }
        return dp[n];
    }
}

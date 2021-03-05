package interview;

public class Problem8_1 {
    /*Description
    * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，
    * 计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
    * */

    public int waysToStep(int n) {
        int mod=1000000007;
        int[] dp=new int[n+3];
        dp[2]=1;
        for(int i=3;i<n+3;i++){
            dp[i]=(dp[i]+dp[i-1])%mod;
            dp[i]=(dp[i]+dp[i-2])%mod;
            dp[i]=(dp[i]+dp[i-3])%mod;
        }
        return dp[n+2];
    }
}

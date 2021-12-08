package leetcode.leetcode13;

public class Leetcode1230 {

    public double probabilityOfHeads(double[] prob, int target) {
        double[][] dp=new double[prob.length+1][target+1];
        dp[0][0]=1;

        for(int i=0;i<prob.length;i++){
            dp[i+1][0]=dp[i][0]*(1-prob[i]);
            for(int j=1;j<=target;j++){
                dp[i+1][j]=dp[i][j]*(1-prob[i])+dp[i][j-1]*prob[i];
            }
        }
        return dp[prob.length][target];
    }
}

package leetcode.leetcode18;

public class Leetcode1774 {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        boolean[] dp=new boolean[20001];
        for(int base:baseCosts)
            dp[base]=true;

        for(int top:toppingCosts){
            dfs(top,dp);
            dfs(top,dp);
        }
        int result=baseCosts[0];
        for(int i=20000;i>=0;i--){
            if(dp[i]){
                result=Math.abs(i-target)<=Math.abs(result-target)?i:result;
            }
        }
        return result;
    }

    private void dfs(int top,boolean[] dp){
        for(int i=dp.length-1;i>=top;i--){
            if(dp[i-top])
                dp[i]=true;
        }
    }
}

package leetcode.leetcode18;

public class Leetcode1758 {
    public int minOperations(String s) {
        int[][] dp=new int[s.length()+1][2];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                dp[i+1][0]=dp[i][1];
                dp[i+1][1]=dp[i][0]+1;
            }else{
                dp[i+1][0]=dp[i][1]+1;
                dp[i+1][1]=dp[i][0];
            }
        }
        return Math.min(dp[s.length()][0],dp[s.length()][1]);
    }
}

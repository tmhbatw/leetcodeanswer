package leetcode.leetcode23;

public class Leetcode2222 {

    public long numberOfWays(String s) {
        long[][] dp=new long[4][2];
        dp[0][0]=dp[0][1]=1;

        for(char cur:s.toCharArray()){
            if(cur=='0'){
                for(int i=3;i>=1;i--){
                    dp[i][0]+=dp[i-1][1];
                }
            }
            else{
                for(int i=3;i>=1;i--){
                    dp[i][1]+=dp[i-1][0];
                }
            }
        }

        return dp[3][0]+dp[3][1];
    }
}

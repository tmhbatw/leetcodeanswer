package leetcode.leetcode11;

public class Leetcode1031 {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int length=nums.length;
        int[] sum=new int[length+1];
        for(int i=0;i<length;i++)
            sum[i+1]=sum[i]+nums[i];

        int[][] dp=new int[length+1][3];
        for(int i=1;i<=length;i++){
            if(i>=firstLen){
                dp[i][0]=Math.max(dp[i-1][0],sum[i]-sum[i-firstLen]);
            }
            if(i>=secondLen){
                dp[i][1]=Math.max(dp[i-1][1],sum[i]-sum[i-secondLen]);
            }
            if(i>=secondLen+firstLen){
                dp[i][2]=Math.max(dp[i-1][2],Math.max(dp[i-firstLen][1]+sum[i]-sum[i-firstLen],
                        dp[i-secondLen][0]+sum[i]-sum[i-secondLen]));
            }
        }

        return dp[length][2];
    }
}

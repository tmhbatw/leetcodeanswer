package leetcode.leetcode17;

public class Leetcode1690 {

    public int stoneGameVII(int[] stones) {
        int length=stones.length;
        int[] sum=new int[length+1];
        for(int i=0;i<length;i++)
            sum[i+1]=sum[i]+stones[i];

        int[][] dp=new int[length][length];
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                dp[i][j]=Math.max(sum[j+1]-sum[i+1]-dp[i+1][j],sum[j]-sum[i]-dp[i][j-1]);
            }
        }

        return dp[0][length-1];
    }
}

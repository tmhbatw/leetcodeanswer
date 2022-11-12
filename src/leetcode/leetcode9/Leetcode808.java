package leetcode.leetcode9;

public class Leetcode808 {

    int[][] next=new int[][]{{-4,0},{-3,-1},{-2,-2},{-1,-3}};
    public double soupServings(int n) {
        if(n==0)
            return 0.5;
        if(n>=10000)
            return 1.00;

        int realTime = (n-1)/25+1;
        double[][] dp=new double[realTime+1][realTime+1];
        dp[realTime][realTime]=1;
        double result=0;

        for(int i=realTime;i>0;i--){
            for(int j=realTime;j>0;j--){
                if(dp[i][j]==0)
                    continue;
                for(int[] nn:next){
                    int ii=i-nn[0];
                    int jj=j-nn[1];

                    if(ii<=0&&jj<=0){
                        result+=dp[i][j]/8;
                    }else if(ii<=0){
                        result+=dp[i][j]/4;
                    } else if (jj > 0) {
                        dp[ii][jj]+=dp[i][j]/4;
                    }
                }
            }
        }

        return result;
    }


}

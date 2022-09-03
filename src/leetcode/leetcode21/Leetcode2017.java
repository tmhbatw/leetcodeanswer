package leetcode.leetcode21;

public class Leetcode2017 {

    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long[] sum1=new long[n+1];
        long[] sum2=new long[n+1];

        for(int i=0;i<grid[0].length;i++){
            sum1[i+1]+=sum1[i]+grid[0][i];
            sum2[i+1]+=sum2[i]+grid[1][i];
        }

        long min=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long cur =Math.max(sum2[i],sum1[n]-sum1[i+1]);
            min=Math.min(min,cur);
        }

        return min;
    }
}

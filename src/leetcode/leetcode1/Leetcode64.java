package leetcode.leetcode1;

public class Leetcode64 {
    /*Description
    *给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    * 说明：每次只能向下或者向右移动一步。
    * */

    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
            dp[i][0]=Integer.MAX_VALUE;
        for(int j=2;j<=n;j++)
            dp[0][j]=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1]=grid[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[m][n];
    }
}

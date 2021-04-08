package leetcode.leetcode1;

public class Leetcode62 {
    /*Description
    * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
    * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    * 问总共有多少条不同的路径？
    * */

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[1][1]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1]+=dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[m][n];
    }
}

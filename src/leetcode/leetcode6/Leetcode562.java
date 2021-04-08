package leetcode.leetcode6;

public class Leetcode562 {
    /*Description
    * 给定一个01矩阵 M，找到矩阵中最长的连续1线段。这条线段可以是水平的、垂直的、对角线的或者反对角线的。
    * */

    public int longestLine(int[][] M) {
        if(M==null||M.length==0||M[0]==null||M[0].length==0)
            return 0;
        int row=M.length,col=M[0].length;
        int[][][] dp=new int[row+1][col+1][4];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(M[i][j]==1){
                    dp[i+1][j+1][0]=dp[i][j+1][0]+1;
                    dp[i+1][j+1][1]=dp[i+1][j][1]+1;
                    dp[i+1][j+1][2]=dp[i][j][2]+1;
                }
            }
        }
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=col-1;j>=0;j--){
                if(M[i][j]==1) {
                    dp[i + 1][j][3] = dp[i][j + 1][3] + 1;
                    result=Math.max(result,Math.max(dp[i+1][j][3],
                            Math.max(dp[i+1][j+1][0],Math.max(dp[i+1][j+1][1],dp[i+1][j+1][2]))));
                }
            }
        }
        return result;
    }
}

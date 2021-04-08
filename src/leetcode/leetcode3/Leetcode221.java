package leetcode.leetcode3;

public class Leetcode221 {
    /*Description
    * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
    * */

    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null)
            return 0;
        int row=matrix.length,col=matrix[0].length;
        int[][] dp1=new int[row+1][col+1];
        int[][] dp2=new int[row+1][col+1];
        int[][] dp3=new int[row+1][col+1];
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp1[i][j]=dp1[i-1][j-1]+1;
                    dp2[i][j]=Math.min(dp1[i-1][j-1],dp2[i-1][j])+1;
                    dp3[i][j]=Math.min(dp1[i-1][j-1],dp3[i][j-1])+1;
                }
            }
        }
        int result=0;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                int curRes=Math.min(Math.min(dp1[i][j],dp2[i][j]),dp3[i][j]);
                result=Math.max(result,curRes);
            }
        }
        return result;
    }
}

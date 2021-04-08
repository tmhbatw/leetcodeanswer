package leetcode.leetcode4;

public class Leetcode304 {
    /*Description
    * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
    * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
    * */

    class NumMatrix {
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if(matrix.length==0||matrix[0].length==0)
                return;
            dp=new int[matrix.length+1][matrix[0].length+1];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    dp[i+1][j+1]=dp[i+1][j]+dp[i][j+1]+matrix[i][j]-dp[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
        }
    }
}

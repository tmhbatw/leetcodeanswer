package leetcode.leetcode8;

public class Leetcode766 {
    /*Description
    * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
    * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
    * */

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        for(int j=0;j<col;j++){
            int cur=matrix[0][j];
            for(int i=1;i<row;i++){
                int jj=i+j;
                if(jj>=col)
                    break;
                if(matrix[i][jj]!=cur)
                    return false;
            }
        }
        for(int i=1;i<row;i++){
            int cur=matrix[i][0];
            for(int j=0;j<col;j++){
                int ii=i+j;
                if(ii>=row){
                    break;
                }
                if(matrix[ii][j]!=cur)
                    return false;
            }
        }
        return true;
    }
}

package leetcode.leetcode1;

public class Leetcode48 {
    /*Description
    *给定一个 n×n 的二维矩阵表示一个图像。
    * 将图像顺时针旋转 90 度。
    * 说明：
    * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
    * */

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int temp=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
}

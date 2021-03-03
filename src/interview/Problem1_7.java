package interview;

public class Problem1_7 {
    /*Description
    * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
    * 请你设计一种算法，将图像旋转 90 度。
    * */

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
    }
}

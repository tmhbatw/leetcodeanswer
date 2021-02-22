package leetcode4;

public class Leetcode308 {
    /*Description
    * 给你一个 2D 矩阵 matrix，请计算出从左上角 (row1, col1)
    * 到右下角 (row2, col2) 组成的矩形中所有元素的和。
    * */

    class NumMatrix {
        int[][] sum;
        int[][] num;
        public NumMatrix(int[][] matrix) {
            if(matrix==null||matrix.length==0||matrix[0].length==0)
                return;
            this.num=matrix;
            int row=matrix.length,col=matrix[0].length;
            sum=new int[row][col+1];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    sum[i][j+1]=sum[i][j]+matrix[i][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            int cur=num[row][col];
            num[row][col]=val;
            for(int j=col+1;j<sum[0].length;j++)
                sum[row][j]+=val-cur;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res=0;
            for(int i=row1;i<=row2;i++)
                res+=sum[i][col2+1]-sum[i][col1];
            return res;
        }
    }
}

package interview;

public class Problem1_8 {
    /*Description
    * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
    * */

    public void setZeroes(int[][] matrix) {
        if(matrix.length==0)
            return;
        int row=matrix.length,col=matrix[0].length;
        boolean[] isZeroRow=new boolean[row];
        boolean[] isZeroCol=new boolean[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    isZeroCol[j]=true;
                    isZeroRow[i]=true;
                }
            }
        }
        for(int i=0;i<row;i++){
            if(isZeroRow[i]){
                for(int j=0;j<col;j++)
                    matrix[i][j]=0;
            }
        }
        for(int j=0;j<col;j++){
            if(isZeroCol[j]){
                for(int i=0;i<row;i++)
                    matrix[i][j]=0;
            }
        }
    }
}

package interview;

public class Problem10_9 {
    /*Description
    * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素
    * */

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        int row=matrix.length,col=matrix[0].length;
        int i=row-1,j=0;
        while(i>=0&&j<col){
            if(matrix[i][j]==target)
                return true;
            if(matrix[i][j]>target)
                i--;
            else
                j++;
        }
        return false;
    }
}

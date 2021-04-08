package leetcode.leetcode3;

public class Leetcode240 {
    /*Description
    * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    * 每行的元素从左到右升序排列。
    * 每列的元素从上到下升序排列。
    * */

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int m=matrix.length,n=matrix[0].length;
        int row=m-1,col=0;
        while(row>=0&&col<n){
            if(matrix[row][col]==target)
                return true;
            if(matrix[row][col]>target)
                row--;
            else
                col++;
        }
        return false;
    }
}

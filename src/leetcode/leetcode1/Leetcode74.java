package leetcode.leetcode1;

public class Leetcode74 {
    /*Description
    * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    * 每行中的整数从左到右按升序排列。
    * 每行的第一个整数大于前一行的最后一个整数。
    * */

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
            return false;
        int m=matrix.length,n=matrix[0].length;
        if(target<matrix[0][0]||matrix[m-1][n-1]<target)
            return false;
        int left=0,right=m*n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int i=(mid)/n,j=mid%n;
            if(matrix[i][j]==target)
                return true;
            if(matrix[i][j]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
}

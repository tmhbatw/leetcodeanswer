package leetcode.leetcode4;

public class Leetcode329 {
    /*Description
    * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
    * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
    * */

    int result=0;
    int[][] matrix;
    int[][] time;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix=matrix;
        int row=matrix.length,col=matrix[0].length;
        time=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dfs(i,j,-1,0,row,col);
            }
        }
        return result;
    }

    private int dfs(int i,int j,int val,int cur,int row,int col){
        if(i>=0&&i<row&&j>=0&&j<col&&matrix[i][j]>val){
            if(time[i][j]!=0)
                return time[i][j];
            int max=0;
            max=Math.max(max,dfs(i+1,j,matrix[i][j],cur+1,row,col));
            max=Math.max(dfs(i-1,j,matrix[i][j],cur+1,row,col),max);
            max=Math.max(dfs(i,j+1,matrix[i][j],cur+1,row,col),max);
            max=Math.max(max,dfs(i,j-1,matrix[i][j],cur+1,row,col));
            result=Math.max(result,max+1);
            time[i][j]=max+1;
            return time[i][j];
        }
        return 0;
    }
}

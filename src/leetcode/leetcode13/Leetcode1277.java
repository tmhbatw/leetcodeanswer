package leetcode.leetcode13;

public class Leetcode1277 {

    public int countSquares(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;

        int[][] res=new int[row+1][col+1];
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0)
                    continue;
                int cur=Math.min(Math.min(res[i][j+1],res[i+1][j]),res[i][j])+1;
                res[i+1][j+1]=cur;
                result+=cur;
            }
        }
        return result;
    }
}

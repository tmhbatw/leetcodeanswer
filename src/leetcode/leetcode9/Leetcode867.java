package leetcode.leetcode9;

public class Leetcode867 {
    public int[][] transpose(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        int[][] res=new int[col][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                res[j][i]=matrix[i][j];
        }
        return res;
    }
}

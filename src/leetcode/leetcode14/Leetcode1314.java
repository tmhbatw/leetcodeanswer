package leetcode.leetcode14;

public class Leetcode1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row=mat.length,col=mat[0].length;
        int[][] sum=new int[row+1][col+1];

        for(int i=0;i<row;i++){
            int curRowPre=0;
            for(int j=0;j<col;j++){
                curRowPre+=mat[i][j];
                sum[i+1][j+1]=sum[i][j+1]+curRowPre;
            }
        }

        int[][] res=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int i1=Math.max(0,i-k);
                int j1=Math.max(0,j-k);
                int i2=Math.min(row-1,i+k);
                int j2=Math.min(col-1,j+k);
                res[i][j]=sum[i2+1][j2+1]-sum[i2+1][j1]-sum[i1][j2+1]+sum[i1][j1];
            }
        }
        return res;
    }
}

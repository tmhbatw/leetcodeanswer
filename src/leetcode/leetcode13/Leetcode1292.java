package leetcode.leetcode13;

public class Leetcode1292 {

    public int maxSideLength(int[][] mat, int threshold) {
        int row=mat.length;
        int col=mat[0].length;
        int[][] sum=new int[row+1][col+1];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                sum[i+1][j+1]=sum[i][j+1]+sum[i+1][j]-sum[i][j]+mat[i][j];
            }
        }

        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=result;k<Math.min(row-i,col-j);k++){
                    int cur = sum[i+k+1][j+k+1]-sum[i+k+1][j]-sum[i][j+k+1]+sum[i][j];
                    if(cur<=threshold){
                        result=k+1;
                    }
                }
            }
        }

        return result;
    }


}

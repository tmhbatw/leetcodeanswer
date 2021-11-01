package leetcode.leetcode17;

public class Leetcode1605 {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res=new int[rowSum.length][colSum.length];
        for(int i=0;i<rowSum.length;i++){
            for(int j=0;j<colSum.length;j++){
                res[i][j]=Math.min(rowSum[i],colSum[j]);
                rowSum[i]-=res[i][j];
                colSum[j]-=res[i][j];
            }
        }
        return res;
    }
}

package leetcode.leetcode20;

public class Leetcode1975 {
    public long maxMatrixSum(int[][] matrix) {
        int negative=0;
        int min=Integer.MAX_VALUE;
        long sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                    sum+=Math.abs(matrix[i][j]);
                    min=Math.min(min,Math.abs(matrix[i][j]));
                    negative+=matrix[i][j]<0?1:0;
            }
        }

        if(min==0||negative%2==0){
            return sum;
        }
        return sum-min* 2L;
    }
}

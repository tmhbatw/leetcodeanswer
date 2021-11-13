package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode931 {
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        if(col==1){
            int sum=0;
            for (int[] ints : matrix) sum += ints[0];
            return sum;
        }
        for(int i=1;i<row;i++){
            matrix[i][0]+=Math.min(matrix[i-1][1],matrix[i-1][0]);
            matrix[i][col-1]+=Math.min(matrix[i-1][col-2],matrix[i-1][col-1]);
            for(int j=1;j<col-1;j++){
                matrix[i][j]+=Math.min(matrix[i-1][j],
                        Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
            }
        }

        return Arrays.stream(matrix[row-1]).min().getAsInt();
    }
}

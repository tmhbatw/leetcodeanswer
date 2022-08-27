package leetcode.leetcode18;

import java.util.Arrays;

public class Leetcode1727 {

    public int largestSubmatrix(int[][] matrix) {
        int[][] time=new int[matrix.length+1][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][j]==1){
                    matrix[i+1][j]=matrix[i][j]+1;
                }
            }
        }

        int result=0;
        for(int i=1;i<time.length;i++){
            Arrays.sort(matrix[i]);
            for(int j=0;j<matrix[i].length;j++){
                result=Math.max(matrix[i][j]*(matrix[i].length-j),result);
            }
        }

        return result;
    }


}

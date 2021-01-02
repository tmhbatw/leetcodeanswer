package leetcode1;

import java.util.HashSet;
import java.util.Set;

public class Leetcode73 {
    /*Description
    * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     * */

    public void setZeroes(int[][] matrix) {
        Set<Integer> setRow=new HashSet<>();
        Set<Integer> setCol=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(setRow.contains(i)||setCol.contains(j))
                    matrix[i][j]=0;
            }
        }
    }
}

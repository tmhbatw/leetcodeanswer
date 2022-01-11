package leetcode.leetcode22;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2133 {

    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=0;j<n;j++){
                if(matrix[i][j]<1||matrix[i][j]>n||set.contains(matrix[i][j]))
                    return false;
                set.add(matrix[i][j]);
            }
        }

        for(int j=0;j<n;j++){
            Set<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++){
                if(matrix[i][j]<1||matrix[i][j]>n||set.contains(matrix[i][j]))
                    return false;
                set.add(matrix[i][j]);
            }
        }
        return true;
    }
}

package leetcode.leetcode11;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int result=0;
        int row=matrix.length,col=matrix[0].length;

        for(int i=0;i<row;i++){

            int[] sum=new int[col];
            for(int j=i;j<row;j++){
                Map<Integer,Integer> map=new HashMap<>();
                map.put(0,1);

                int curSum=0;
                for(int k=0;k<col;k++) {
                    sum[k] += matrix[j][k];
                    curSum+=sum[k];
                    result+=map.getOrDefault(curSum-target,0);
                    map.put(curSum,map.getOrDefault(curSum,0)+1);
                }
            }
        }

        return result;
    }
}

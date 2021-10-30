package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(o1,o2)->{
            return o1[0]-o2[0];
        });

        int result=0;
        for(int i=0;i<points.length-1;i++){
            result=Math.max(result,points[i+1][0]-points[i][0]);
        }
        return result;
    }
}

package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->{
            return o1[0]-o2[0];
        });

        int result=0;
        int pre=Integer.MIN_VALUE;
        for(int[] cur:intervals){
            if(cur[0]<pre){
                result++;
                pre=Math.min(pre,cur[1]);
            }else
                pre=cur[1];
        }

        return result;
    }
}

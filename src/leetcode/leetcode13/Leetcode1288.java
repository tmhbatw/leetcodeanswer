package leetcode.leetcode13;

import java.util.Arrays;

public class Leetcode1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->{
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o1[0]-o2[0];
        });

        int result=intervals.length;
        int max=0;
        for(int[] interval:intervals){
            if(interval[1]<=max)
                result--;
            else
                max=interval[1];
        }
        return result;
    }
}

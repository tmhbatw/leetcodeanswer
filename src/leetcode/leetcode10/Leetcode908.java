package leetcode.leetcode10;

import java.util.Arrays;
import java.util.OptionalInt;

public class Leetcode908 {

    public int smallestRangeI(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int cur:nums){
            min=Math.min(cur,min);
            max=Math.max(cur,max);
        }
        if(max-min<=k*2)
            return 0;
        return max-min-2*k;
    }
}

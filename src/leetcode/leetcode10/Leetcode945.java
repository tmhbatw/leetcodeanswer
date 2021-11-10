package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode945 {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        int pre=-1;
        for(int num:nums){
            res+=Math.max(pre,num)-num;
            pre++;
        }
        return res;
    }
}

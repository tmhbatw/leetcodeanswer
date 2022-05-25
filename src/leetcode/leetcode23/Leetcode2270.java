package leetcode.leetcode23;

import java.util.Arrays;

public class Leetcode2270 {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;

        int result = 0;
        long cur =0;
        for(int num:nums)
            sum+=num;

        for(int i=0;i<nums.length-1;i++){
            sum-=nums[i];
            cur += nums[i];

            if(cur>=sum)
                result++;
        }

        return result;
    }
}

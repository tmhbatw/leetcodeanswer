package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode910 {

    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int result=nums[nums.length-1]-nums[0];
        for(int i=0;i<nums.length-1;i++){
            //开始到第i个数增，剩下的减
            int max=Math.max(nums[i]+k,nums[nums.length-1]-k);
            int min=Math.min(nums[i+1]-k,nums[0]+k);
            result=Math.min(result,max-min);
        }
        return result;
    }

}

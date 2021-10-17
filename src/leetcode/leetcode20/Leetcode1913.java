package leetcode.leetcode20;

import java.util.Arrays;

public class Leetcode1913 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        return nums[length-1]*nums[length-2]-nums[0]*nums[1];
    }
}

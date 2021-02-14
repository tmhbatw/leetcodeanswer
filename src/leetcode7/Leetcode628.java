package leetcode7;

import java.util.Arrays;

public class Leetcode628 {
    /*Description
    * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
    * */

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        return Math.max(nums[0]*nums[1]*nums[length-1],nums[length-1]*nums[length-2]*nums[length-3]);
    }
}

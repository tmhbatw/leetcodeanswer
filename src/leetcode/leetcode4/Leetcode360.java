package leetcode.leetcode4;

import java.util.Arrays;

public class Leetcode360 {
    /*Descripton
    * 给你一个已经排好序的整数数组nums和整数a、b、c。对于数组中的每一个数 x，计算函数值f(x) = ax2 + bx + c，请将函数值产生的数组返回。
    * 要注意，返回的这个数组必须按照 升序排列，并且我们所期望的解法时间复杂度为O(n)。
    * */

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums==null)
            return null;
        for(int i=0;i<nums.length;i++){
            nums[i]=a*nums[i]*nums[i]+b*nums[i]+c;
        }
        Arrays.sort(nums);
        return nums;
    }
}

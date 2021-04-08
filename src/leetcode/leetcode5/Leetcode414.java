package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode414 {
    /*Description
    * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
    * */

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int index=nums.length-1;
        for(int i=0;i<2;i++){
            if(index>=1&&nums[index-1]==nums[index])
                index--;
            index--;
        }
        return index<0?-1:nums[index];
    }
}

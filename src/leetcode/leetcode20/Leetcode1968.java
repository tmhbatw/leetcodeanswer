package leetcode.leetcode20;

import java.util.Arrays;

public class Leetcode1968 {

    public int[] rearrangeArray(int[] nums) {
        int[] result=new int[nums.length];
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        boolean  flag = true;
        for(int index=0;index<nums.length;index++){
            result[index]=flag?nums[i++]:nums[j--];
            flag=!flag;
        }
        return result;
    }


}

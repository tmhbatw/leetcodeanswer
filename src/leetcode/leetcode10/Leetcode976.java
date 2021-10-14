package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode976 {

    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        int result=0;

        int index1=2;
        for(int i=0;i<nums.length-2;i++){
            if(i+1==index1)
                index1++;
            int val1=nums[i];
            int val2=nums[i+1];


            while(index1<nums.length&&val1+val2>nums[index1]){
                index1++;
            }
            index1--;

            if(val1+val2>nums[index1]&&index1>i+1)
                result=Math.max(result,val1+val2+nums[index1]);
        }
        return result;
    }
}

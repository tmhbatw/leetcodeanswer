package leetcode.leetcode11;

import java.util.Arrays;

public class Leetcode1099 {

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=-1;
        int l=0,r=nums.length-1;
        while(l<r){
            if(nums[l]+nums[r]>=k)
                r--;
            else{
                sum=Math.max(sum,nums[l]+nums[r]);
                l++;
            }
        }
        return sum;
    }
}

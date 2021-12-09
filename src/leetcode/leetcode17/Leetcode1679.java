package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1679 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result=0;
        int l=0,r=nums.length-1;

        while(l<r){
            if(nums[l]+nums[r]==k){
                l++;
                r--;
                result++;
            }
            if(nums[l]+nums[r]<k)
                l++;
            if(nums[l]+nums[r]>k)
                r--;
        }
        return result;
    }
}

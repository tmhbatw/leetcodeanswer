package leetcode.leetcode6;

import java.util.Arrays;

public class Leetcode581 {

    public int findUnsortedSubarray(int[] nums) {
        int[] num=nums.clone();
        Arrays.sort(num);

        int l=0;
        for(;l<nums.length;l++){
            if(nums[l]!=num[l])
                break;
        }
        int r=nums.length-1;
        for(;r>l;r--){
            if(nums[r]!=num[r])
                break;
        }
        return r-l+1;
    }
}

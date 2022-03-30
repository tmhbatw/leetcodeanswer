package leetcode.leetcode23;

import java.util.Arrays;

public class Leetcode2206 {

    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                count++;
                i++;
            }
        }

        return count==nums.length/2;
    }
}

package leetcode.leetcode25;

import java.util.Arrays;

public class Leetcode2419 {

    public int longestSubarray(int[] nums) {
        int max= Arrays.stream(nums).max().getAsInt();
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                int start=i;
                while(i<nums.length-1&&nums[i+1]==nums[i])
                    i++;
                result=Math.max(result,i-start+1);
            }
        }
        return result;
    }


}

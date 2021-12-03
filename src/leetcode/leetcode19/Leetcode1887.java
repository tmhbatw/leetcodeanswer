package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1887 {

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        int count=0;

        for(int j=nums.length-1;j>=0;j--){
            while(j>=1&&nums[j-1]==nums[j]){
                j--;
                count++;
            }
            count++;
            if(j!=0)
                result+=count;
        }
        return result;
    }
}

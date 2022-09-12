package leetcode.leetcode25;

import java.util.Arrays;

public class Leetcode2404 {

    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int result = -1;
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1)
                continue;
            int start = i;
            while(i<nums.length-1&&nums[i+1]==nums[i])
                i++;

            if(i-start+1>res){
                res=i-start+1;
                result = nums[i];
            }
        }

        return result;
    }


}

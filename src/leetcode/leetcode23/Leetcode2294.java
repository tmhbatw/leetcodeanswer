package leetcode.leetcode23;

import java.util.Arrays;

public class Leetcode2294 {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int start = nums[i];
            count ++;
            while(i<nums.length-1&&nums[i+1]-start<=k)
                i++;
        }

        return count ;
    }
}

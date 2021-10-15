package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1403 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum= Arrays.stream(nums).sum();

        List<Integer> result=new ArrayList<>();
        int curSum=0;

        for(int j=nums.length-1;j>=0;j--){
            curSum+=nums[j];
            result.add(nums[j]);
            if(curSum+curSum>sum){
                return result;
            }
        }

        return result;
    }
}

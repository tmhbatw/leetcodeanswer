package leetcode4;

import java.util.Arrays;

public class Leetcode377 {
    /*Description
    * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     * */

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j])
                    dp[i]+=dp[i-nums[j]];
                else
                    break;
            }
        }
        return target==0?0:dp[target];
    }

    private int getRes(int[] nums,int target,int start){
        if(target==nums[start])
            return 1;
        int result=0;
        for(int i=start;i<nums.length;i++){
            if(nums[i]>target)
                return result;
            result+=getRes(nums,target-nums[i],i);
        }
        return result;
    }
}

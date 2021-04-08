package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode416 {
    /*Description
    * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    * 注意:
    * 每个数组中的元素不会超过 100
    * 数组的大小不会超过 200
    * */

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int cur:nums)
            sum+=cur;
        if(sum%2==1)
            return false;
        sum/=2;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=0;j--){
                if(j>=nums[i]&&dp[j-nums[i]]) {
                    dp[j] = true;
                }
            }
        }
        return dp[sum];
    }
}

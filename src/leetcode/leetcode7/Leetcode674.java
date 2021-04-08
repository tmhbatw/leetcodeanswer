package leetcode.leetcode7;

public class Leetcode674 {
    /*Description
    * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
    * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
    * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
    * */

    public int findLengthOfLCIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int[] dp=new int[nums.length];
        dp[0]=1;
        int result=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
                result=Math.max(dp[i],result);
            }
            else
                dp[i]=1;
        }
        return result;
    }
}

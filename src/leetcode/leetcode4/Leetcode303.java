package leetcode.leetcode4;

public class Leetcode303 {
    /*Description
    * 给定一个整数数组nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
    * 实现 NumArray 类：NumArray(int[] nums) 使用数组 nums 初始化对象
    * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）
    * 范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
    * */

    class NumArray {
        int[] dp;

        public NumArray(int[] nums) {
            dp=new int[nums.length+1];
            for(int i=0;i<nums.length;i++)
                dp[i+1]+=dp[i]+nums[i];
        }

        public int sumRange(int i, int j) {
            return dp[j+1]-dp[i];
        }
    }
}

package leetcode1;

public class Leetcode53 {
    /*Description
    *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * */

    public int maxSubArray(int[] nums) {
        int preSum=0;
        int sum=0;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            result=Math.max(result,sum-preSum);
            preSum=Math.min(preSum,sum);
        }
        return result;
    }
}

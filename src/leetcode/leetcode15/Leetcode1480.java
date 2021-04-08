package leetcode.leetcode15;

public class Leetcode1480 {
    /*Description
    * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
    * 请返回 nums 的动态和。
    * */

    public int[] runningSum(int[] nums) {
        int length=nums.length;
        int[] res=new int[length];
        int preSum=0;
        for(int i=0;i<length;i++){
            res[i]=preSum+nums[i];
            preSum=res[i];
        }
        return res;
    }
}

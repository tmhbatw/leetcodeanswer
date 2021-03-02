package forOffer;

public class forOffer42 {
    /*Description
    * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    * 要求时间复杂度为O(n)。
    * */

    public int maxSubArray(int[] nums) {
        int min=0;
        int curSum=0;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];
            res=Math.max(res,curSum-min);
            min=Math.min(min,curSum);
        }
        return res;
    }
}

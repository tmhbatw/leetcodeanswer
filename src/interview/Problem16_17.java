package interview;

public class Problem16_17 {
    /*Description
    * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
    * */

    public int maxSubArray(int[] nums) {
        int pre=0;
        int max=Integer.MIN_VALUE;
        int curSum=0;
        for(int cur:nums){
            curSum+=cur;
            max=Math.max(max,curSum-pre);
            pre=Math.min(pre,curSum);
        }
        return max;
    }
}

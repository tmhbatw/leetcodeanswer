package leetcode.leetcode18;

public class Leetcode1749 {

    public int maxAbsoluteSum(int[] nums) {
        //保留一个最大值一个最小值
        int max=0;
        int min=0;
        int result=0;
        int preSum=0;

        for(int num:nums){
            preSum+=num;
            result=Math.max(result,Math.max(Math.abs(preSum-max),Math.abs(preSum-min)));
            max=Math.max(preSum,max);
            min=Math.min(preSum,min);
        }
        return result;
    }
}

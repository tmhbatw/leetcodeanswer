package leetcode.leetcode4;

public class Leetcode396 {

    public int maxRotateFunction(int[] nums) {
        int result=Integer.MIN_VALUE;
        int pre=0;
        int sum=0;
        int length=nums.length;
        for(int i=0;i<nums.length;i++) {
            pre += nums[i] * i;
            sum+=nums[i];
        }
        for (int num : nums) {
            pre += length * num - sum;
            result = Math.max(result, pre);
        }
        return result;
    }
}

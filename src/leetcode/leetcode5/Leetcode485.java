package leetcode.leetcode5;

public class Leetcode485 {
    /*Description
    * 给定一个二进制数组， 计算其中最大连续1的个数。
     * */

    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==1) {
                nums[i] += nums[i - 1];
                result=Math.max(result,nums[i]);
            }
        }
        return Math.max(result,nums[0]);
    }
}

package leetcode7;

public class Leetcode643 {
    /*Description
    * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
    * */

    public double findMaxAverage(int[] nums, int k) {
        int curRes=0;
        for(int i=0;i<k-1;i++)
            curRes+=nums[i];
        double result=Integer.MIN_VALUE;
        for(int i=k-1;i<nums.length;i++){
            curRes+=nums[i];
            result=Math.max(result,curRes*1.0/k);
            curRes-=nums[i-k+1];
        }
        return result;
    }
}

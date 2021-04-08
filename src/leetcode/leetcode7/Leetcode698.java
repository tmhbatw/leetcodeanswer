package leetcode.leetcode7;

public class Leetcode698 {
    /*Description
    * 给定一个整数数组  nums 和一个正整数 k，找出是否有
    * 可能把这个数组分成 k 个非空子集，其总和都相等。
     * */

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int cur:nums)
            sum+=cur;
        if(sum%k!=0)
            return false;
        return false;
    }
}

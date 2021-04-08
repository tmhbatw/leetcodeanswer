package leetcode.leetcode3;

public class Leetcode268 {
    /*Description
    * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
    * */

    public int missingNumber(int[] nums) {
        int n=nums.length;
        n=(n+1)*n/2;
        for(int cur:nums)
            n-=cur;
        return n;
    }
}

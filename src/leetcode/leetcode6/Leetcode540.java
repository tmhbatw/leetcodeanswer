package leetcode.leetcode6;

public class Leetcode540 {
    /*Description
    *给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
    * */
    public int singleNonDuplicate(int[] nums) {
        int result=0;
        for(int cur:nums){
            result^=cur;
        }
        return result;
    }

}

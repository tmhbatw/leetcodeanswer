package leetcode.leetcode1;

public class Leetcode26 {
    /*Description
    * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    * */

    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length<2)
            return nums.length;
        int slow=0,fast=1;
        while(fast<nums.length){
            if(nums[slow]!=nums[fast]){
                nums[++slow]=nums[fast++];
            }else
                fast++;
        }
        return slow+1;

    }
}

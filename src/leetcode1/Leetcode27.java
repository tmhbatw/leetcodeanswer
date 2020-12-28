package leetcode1;

public class Leetcode27 {
    /*Description
    *给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
    * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    * */

    public int removeElement(int[] nums, int val) {
        int slow=0;
        int fast=0;
        while(fast<nums.length){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast++];
            }
            else
                fast++;
        }
        return slow;
    }
}

package leetcode3;

import java.util.Arrays;

public class Leetcode280 {
    /*Description
    * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
     * */

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i+=2){
            int temp=nums[i];
            nums[i]=nums[i+1];
            nums[i+1]=temp;
        }
    }
}

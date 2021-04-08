package leetcode.leetcode1;

public class Leetcode41 {
    /*Description
    * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     * */

    public int firstMissingPositive(int[] nums) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            while(nums[i]<=length&&nums[i]>0&&nums[nums[i]-1]!=nums[i]){
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
        }
        for(int i=0;i<length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return length+1;
    }
}

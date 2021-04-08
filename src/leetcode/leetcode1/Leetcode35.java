package leetcode.leetcode1;

public class Leetcode35 {
    /*Description
    *给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    * 你可以假设数组中无重复元素。
    * */

    public int searchInsert(int[] nums, int target) {
        if(nums[0]>target)
            return 0;
        int length=nums.length;
        if(nums[length-1]<target)
            return length;
        int left=0,right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target) {
                if(nums[mid+1]>target)
                    return mid+1;
                left = mid + 1;
            }
            else if(nums[mid]==target)
                return mid;
            else
                right=mid-1;
        }
        return left;
    }
}

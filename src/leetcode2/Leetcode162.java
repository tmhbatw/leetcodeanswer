package leetcode2;

public class Leetcode162 {
    /*Description
    * 峰值元素是指其值大于左右相邻值的元素。
    * 给定一个输入数组nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
    * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
    * 你可以假设nums[-1] = nums[n] = -∞。
    * */

    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length<=1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        int length=nums.length;
        if(nums[length-1]>nums[length-2])
            return length-1;
        int left=0,right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1])
                return mid;
            if(nums[mid]<nums[mid+1])
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
    }
}

package leetcode8;

public class Leetcode704 {
    /*Description
    * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，
    * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
    * */

    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target)
                right=mid-1;
            else if(nums[mid]<target)
                left=mid+1;
            else
                return mid;
        }
        return -1;
    }
}

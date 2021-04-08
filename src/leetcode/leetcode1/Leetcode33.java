package leetcode.leetcode1;

public class Leetcode33 {
    /*Description
    * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为[4,5,6,7,0,1,2] ）。
    * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
    * */

    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                return i;
        }
        return -1;
    }
}

package leetcode.leetcode1;

public class Leetcode81 {
    /*Description
    * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    * ( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。
    * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回true，否则返回false。
    * */

    public boolean search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
            if(nums[i]==target)
                return true;
            return false;
    }
}

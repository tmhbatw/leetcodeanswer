package leetcode.leetcode2;

public class Leetcode153 {
    /*Description
    * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。
    * 请找出其中最小的元素。
    * */

    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int cur:nums)
            min=Math.min(cur,min);
        return min;
    }
}

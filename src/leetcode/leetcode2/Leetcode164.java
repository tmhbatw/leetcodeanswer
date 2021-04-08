package leetcode.leetcode2;

import java.util.Arrays;

public class Leetcode164 {
    /*Description
    * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
    * 如果数组元素个数小于 2，则返回 0。
    * */

    public int maximumGap(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        Arrays.sort(nums);
        int res=0;
        for(int i=1;i<nums.length;i++)
            res=Math.max(nums[i]-nums[i-1],res);
        return res;
    }
}

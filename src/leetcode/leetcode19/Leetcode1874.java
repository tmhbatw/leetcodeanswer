package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1874 {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int result=0;
        int length=nums1.length;
        for(int i=0;i<length;i++)
            result+=nums1[i]*nums2[length-i-1];

        return result;
    }
}

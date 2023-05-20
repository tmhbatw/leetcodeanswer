package leetcode.leetcode27;

import java.util.Arrays;

public class Leetcode2605 {

    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        for (int k : nums2) {
            while (i < nums1.length && nums1[i] < k) {
                i++;
            }
            if (i < nums1.length && nums1[i] == k)
                return k;
        }
        return nums1[0] + nums2[0] + 9 * Math.min(nums1[0], nums2[0]);
    }

}

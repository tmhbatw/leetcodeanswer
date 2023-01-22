package leetcode.leetcode26;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2540 {

    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);

        int result = Integer.MAX_VALUE;
        for (int num : nums2) {
            if (set.contains(num)) {
                result = Math.min(result, num);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

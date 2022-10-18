package leetcode.leetcode25;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2441 {

    public int findMaxK(int[] nums) {
        int result = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(-num)) {
                result = Math.max(result, Math.max(num, -num));
            }
            set.add(num);
        }

        return result;
    }


}

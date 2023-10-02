package leetcode.leetcode29;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode2869 {

    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(nums.size() - 1 - i) <= k) {
                set.add(nums.get(nums.size() - 1 - i));
                if (set.size() == k) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

}

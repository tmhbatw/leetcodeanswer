package leetcode.leetcode27;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode2670 {

    public int[] distinctDifferenceArray(int[] nums) {
        int[] result = new int[nums.length];
        Set<Integer> pre = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) - 1);
            if (map.get(nums[i]) == 0) {
                map.remove(nums[i]);
            }
            pre.add(nums[i]);
            result[i] = pre.size() - map.size();
        }
        return result;
    }

}

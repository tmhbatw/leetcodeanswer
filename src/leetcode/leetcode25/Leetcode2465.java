package leetcode.leetcode25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode2465 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i] + nums[nums.length - 1 - i]);
        }

        return set.size();
    }


}

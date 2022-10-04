package leetcode.leetcode6;

import java.util.HashSet;
import java.util.Set;

public class Leetcode548 {

    public boolean splitArray(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];
        for (int j = 3; j < nums.length - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i] == sum[j] - sum[i + 1])
                    set.add(sum[i]);
            }
            if (set.size() == 0)
                continue;

            for (int k = j + 2; k < nums.length - 1; k++) {
                if (sum[k] - sum[j + 1] == sum[nums.length] -
                        sum[k + 1] && set.contains(sum[k] - sum[j + 1]))
                    return true;
            }
        }
        return false;
    }

}

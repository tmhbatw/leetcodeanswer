package leetcode.leetcode25;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long result = 0;
        long cur = 0;

        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i < k - 1)
                continue;
            if (map.size() == k) {
                result = Math.max(result, cur);
            }

            cur -= nums[i - k + 1];
            map.put(nums[i - k + 1], map.get(nums[i - k + 1]));
            if (map.get(nums[i - k + 1]) == 0)
                map.remove(nums[i - k + 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }


}

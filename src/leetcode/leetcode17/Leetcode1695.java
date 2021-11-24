package leetcode.leetcode17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1695 {

    public int maximumUniqueSubarray(int[] nums) {

        int result=0;
        int j=0;
        int length=nums.length;
        int cur=0;
        Set<Integer> map=new HashSet<>();

        for (int num : nums) {
            while (j < length && !map.contains(nums[j])) {
                cur += nums[j];
                map.add(nums[j++]);
            }
            result = Math.max(result, cur);
            cur -= num;
            map.remove(num);
        }

        return result;
    }
}

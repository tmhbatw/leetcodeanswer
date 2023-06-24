package leetcode.leetcode28;

import java.util.Arrays;

public class Leetcode2733 {

    public int findNonMinOrMax(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        for (int num : nums) {
            if (num < max && num > min)
                return num;
        }

        return -1;
    }

}

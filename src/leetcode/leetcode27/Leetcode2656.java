package leetcode.leetcode27;

import java.util.Arrays;

public class Leetcode2656 {

    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        return (max + max + k - 1) * k / 2;
    }

}

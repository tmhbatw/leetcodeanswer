package leetcode.leetcode26;

import java.util.Arrays;

public class Leetcode2500 {

    public int deleteGreatestValue(int[][] grid) {
        int result = 0;
        for (int[] cur : grid) {
            Arrays.sort(cur);
        }

        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int[] ints : grid) {
                max = Math.max(max, ints[j]);
            }
            result += max;
        }

        return result;
    }

}

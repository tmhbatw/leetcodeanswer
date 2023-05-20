package leetcode.leetcode26;

public class Leetcode2574 {


    public int[] leftRightDifference(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        int[] right = new int[length];
        for (int j = length - 2; j >= 0; j--) {
            right[j] = right[j + 1] + nums[j + 1];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Math.abs(left[i] - right[i]);
        }
        return result;
    }
}

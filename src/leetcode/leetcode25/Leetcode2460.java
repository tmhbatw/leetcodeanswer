package leetcode.leetcode25;

public class Leetcode2460 {

    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int j = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j == nums.length)
                nums[i] = 0;
            else {
                nums[i] = nums[j++];
            }
        }

        return nums;
    }

}

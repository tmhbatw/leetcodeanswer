package leetcode.leetcode28;

public class Leetcode2717 {

    public int semiOrderedPermutation(int[] nums) {
        int m = 0, n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                m = i;
            }
            if (nums[i] == nums.length) {
                n = i;
            }
        }

        int result = m + nums.length - 1 - n;
        if (m > n) {
            result--;
        }
        return result;
    }

}

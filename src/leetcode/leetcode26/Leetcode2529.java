package leetcode.leetcode26;

public class Leetcode2529 {

    public int maximumCount(int[] nums) {
        int cur1 = 0;
        int cur2 = 0;
        for (int num : nums) {
            if (num > 0) {
                cur1++;
            }
            if (num < 0) {
                cur2++;
            }
        }

        return Math.max(cur1, cur2);
    }

}

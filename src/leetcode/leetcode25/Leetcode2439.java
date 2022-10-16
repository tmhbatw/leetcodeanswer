package leetcode.leetcode25;

public class Leetcode2439 {

    public int minimizeArrayValue(int[] nums) {
        int l = nums[0], r = 1000000000;

        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (match(nums, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    private boolean match(int[] nums, int mid) {
        long cur = nums[nums.length - 1];
        for (int j = nums.length - 1; j >= 1; j--) {
            if (cur > mid) {
                cur = (cur - mid) + nums[j - 1];
            } else {
                cur = nums[j - 1];
            }
        }
        return cur <= mid;
    }


}

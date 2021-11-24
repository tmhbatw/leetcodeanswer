package leetcode.leetcode15;

public class Leetcode1493 {

    public int longestSubarray(int[] nums) {
        int result=0;
        boolean hasZero=false;
        int cur=0;
        int j=0;
        for (int num : nums) {
            while (j < nums.length && (nums[j] == 1 || !hasZero)) {
                if (nums[j++] == 0)
                    hasZero = true;
                cur++;
            }
            result = Math.max(cur - 1, result);
            if (j == nums.length)
                break;
            if (num == 0)
                hasZero = false;
            cur--;
        }
        return result;
    }
}

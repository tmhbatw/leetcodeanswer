package leetcode.leetcode26;

public class Leetcode2562 {

    public long findTheArrayConcVal(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            result += getRes(nums[i], nums[nums.length - i - 1]);
        }
        if (nums.length % 2 == 1) {
            result += nums[nums.length / 2];
        }
        return result;
    }

    private long getRes(int a, int b) {
        int length = (b + "").length();
        return (long) (Math.pow(10, length) * a + b);
    }
}

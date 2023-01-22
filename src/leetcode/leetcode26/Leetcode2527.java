package leetcode.leetcode26;

public class Leetcode2527 {

    public int xorBeauty(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}

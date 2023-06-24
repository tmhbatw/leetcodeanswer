package leetcode.leetcode27;

public class Leetcode2644 {

    public int maxDivScore(int[] nums, int[] divisors) {
        int score = 0;
        int result = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            int count = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    count++;
                }
            }
            if (count > score || count == score && result > divisor) {
                result = divisor;
                score = count;
            }
        }
        return result;
    }

}

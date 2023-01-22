package leetcode.leetcode26;

public class Leetcode2535 {

    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int sum2 = 0;
        for (int num : nums) {
            sum += num;
            while (num > 0) {
                sum2 += num % 10;
                num /= 10;
            }
        }
        return Math.abs(sum2 - sum);
    }

}

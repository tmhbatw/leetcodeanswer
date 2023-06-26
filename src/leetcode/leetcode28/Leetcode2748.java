package leetcode.leetcode28;

public class Leetcode2748 {

    public int countBeautifulPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int ii = (nums[i] + "").charAt(0) - '0';
            for (int j = i + 1; j < nums.length; j++) {
                int jj = nums[j] % 10;

                if (gcd(ii, jj) == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private int gcd(int i, int j) {
        if (i < j) {
            return gcd(j, i);
        }
        if (i % j == 0)
            return j;
        return gcd(j, i % j);
    }
}

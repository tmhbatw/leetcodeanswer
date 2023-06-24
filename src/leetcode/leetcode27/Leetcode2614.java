package leetcode.leetcode27;

public class Leetcode2614 {

    public int diagonalPrime(int[][] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i][i])) {
                result = Math.max(result, nums[i][i]);
            }
            if (isPrime(nums[nums.length - i - 1][i])) {
                result = Math.max(result, nums[nums.length - 1 - i][i]);
            }
        }
        return result;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        if (num != 2 && num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}

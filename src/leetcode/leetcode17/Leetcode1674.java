package leetcode.leetcode17;

public class Leetcode1674 {

    public int minMoves(int[] nums, int limit) {
        int[] res = new int[limit * 2 + 2];
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            int sum = nums[i] + nums[length - 1 - i];

            //从2到oneMin-1要修改2次，从oneMin到sum-1要修改1次
            int oneMin = 1 + Math.min(nums[i], nums[length - 1 - i]);
            res[2] += 2;
            res[oneMin]--;
            res[sum]--;

            //从sum+1到OneMax要修改1次，从OneMax到limit*2修改2次
            int OneMax = limit + Math.max(nums[i], nums[length - 1 - i]);
            res[sum + 1]++;
            res[OneMax + 1]++;
            res[limit * 2 + 1] -= 2;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 2; i <= limit * 2; i++) {
            res[i] += res[i - 1];
            result = Math.min(result, res[i]);
        }

        return result;
    }

}

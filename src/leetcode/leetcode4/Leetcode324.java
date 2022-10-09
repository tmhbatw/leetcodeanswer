package leetcode.leetcode4;

import java.util.Arrays;

public class Leetcode324 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int mid = (nums.length + 1) / 2;

        for (int i = 0; i < nums.length / 2; i++) {
            res[i * 2] = nums[mid - i];
            res[i * 2 + 1] = nums[nums.length - 1 - i];
        }
        if (nums.length % 2 == 1)
            res[nums.length - 1] = nums[0];
        System.arraycopy(res, 0, nums, 0, nums.length);
    }


}

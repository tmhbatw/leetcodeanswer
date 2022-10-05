package leetcode.leetcode23;

import java.util.PriorityQueue;

public class Leetcode2263 {

    public int convertArray(int[] nums) {
        return Math.min(getRes(nums), getRes(reverse(nums)));
    }

    private int getRes(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int result = 0;
        for (int num : nums) {
            if (!q.isEmpty() && q.peek() < num) {
                result += num - q.poll();
                q.add(num);
            }
            q.add(num);
        }
        return result;
    }

    private int[] reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        return nums;
    }
}

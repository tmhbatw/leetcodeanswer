package leetcode.leetcode25;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode2453 {

    public int[] secondGreaterElement(int[] nums) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                result[s2.pop()] = nums[i];
            }
            Stack<Integer> cur = new Stack<>();
            while (!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
                cur.add(s1.pop());
            }
            while (!cur.isEmpty())
                s2.add(cur.pop());
            s1.add(i);
        }

        return result;
    }


}

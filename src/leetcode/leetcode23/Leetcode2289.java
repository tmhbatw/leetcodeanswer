package leetcode.leetcode23;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode2289 {

    public int totalSteps(int[] nums) {
        int result=0;

        Stack<int[]> s=new Stack<>();

        for (int num : nums) {
            int cur = 0;
            while (!s.empty() && s.peek()[0] <= num) {
                cur = Math.max(cur, s.pop()[1]);
            }

            if (s.empty()) {
                s.add(new int[]{num, 0});
            } else {
                s.add(new int[]{num, cur + 1});
                result = Math.max(cur + 1, result);
            }

        }


        return result;
    }

}

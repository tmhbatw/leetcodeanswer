package leetcode.leetcode29;

import java.util.List;

public class Leetcode2859 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            String cur = Integer.toBinaryString(i);
            int num = 0;
            for (char c : cur.toCharArray()) {
                if (c == '1') {
                    num++;
                }
            }
            if (num == k) {
                result += nums.get(i);
            }
        }
        return result;
    }

}

package leetcode.leetcode26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode2553 {

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.addAll(getRes(num));
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }

    private List<Integer> getRes(int num) {
        List<Integer> result = new ArrayList<>();
        if (num == 0) {
            result.add(0);
            return result;
        }
        while (num > 0) {
            result.add(num % 10);
            num /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}

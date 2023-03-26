package leetcode.leetcode26;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2578 {

    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        list.sort((o1, o2) -> o2 - o1);
        int base = 1;
        boolean even = true;
        int result = 0;
        for (int cur : list) {
            result += cur * base;
            even = !even;
            if (even) {
                base *= 10;
            }
        }
        return result;
    }

}

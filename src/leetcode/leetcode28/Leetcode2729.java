package leetcode.leetcode28;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2729 {

    public boolean isFascinating(int n) {
        Set<Integer> set = new HashSet<>();
        if (n > 333) {
            return false;
        }
        for (int num : new int[]{n, n * 2, n * 3}) {
            while (num > 0) {
                set.add(num % 10);
                num /= 10;
            }
        }
        return set.size() == 9 && !set.contains(0);
    }

}

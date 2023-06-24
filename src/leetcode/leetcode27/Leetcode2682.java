package leetcode.leetcode27;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2682 {

    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int cur = 1;
        int i = 1;
        while (!set.contains(cur)) {
            set.add(cur);
            cur = (cur + (i++) * k) % n;
            if (cur == 0) {
                cur = n;
            }
        }

        int[] result = new int[n - set.size()];
        int index = 0;
        for (int j = 1; j <= n; j++) {
            if (!set.contains(j)) {
                result[index++] = j;
            }
        }
        return result;
    }

}

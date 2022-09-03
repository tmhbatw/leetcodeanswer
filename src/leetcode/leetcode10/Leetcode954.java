package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Leetcode954 {

    public boolean canReorderDoubled(int[] arr) {
        int count0 = 0;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int num : arr) {
            if (num == 0)
                count0++;
            if (num > 0)
                positive.add(num);
            if (num < 0)
                negative.add(-num);
        }
        return count0 % 2 == 0 && canReorder(positive) && canReorder(negative);
    }

    private boolean canReorder(List<Integer> list) {
        Collections.sort(list);
        boolean[] reached = new boolean[list.size()];
        int j = 1;
        for (int i = 0; i < list.size(); i++) {
            if (reached[i])
                continue;
            while (j < list.size() && list.get(j) < list.get(i) * 2)
                j++;
            if (j == list.size() || list.get(j) > list.get(i) * 2)
                return false;
            reached[j++] = true;
        }
        return true;
    }

}

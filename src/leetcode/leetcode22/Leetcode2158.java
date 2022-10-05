package leetcode.leetcode22;

import java.util.Map;
import java.util.TreeMap;

public class Leetcode2158 {

    public int[] amountPainted(int[][] paint) {
        int[] result = new int[paint.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < paint.length; i++) {
            int start = paint[i][0];
            int end = paint[i][1];

            int entry = -1;
            if (map.floorKey(start) != null) {
                Map.Entry<Integer, Integer> pre = map.floorEntry(start);
                if (pre.getValue() >= end)
                    continue;
                if (pre.getValue() >= start) {
                    start = pre.getValue();
                    entry = pre.getKey();
                    map.put(pre.getKey(), end);
                }
            }

            if (entry == -1) {
                map.put(start, end);
                entry = start;
            }

            while (map.higherKey(start) != null && map.higherKey(start) <= end) {
                int higherKey = map.higherKey(start);
                result[i] += higherKey - start;

                if (map.get(higherKey) >= end) {
                    map.put(entry, map.get(higherKey));
                    map.remove(higherKey);
                    start = end;
                    break;
                } else {
                    start = map.get(higherKey);
                    map.remove(higherKey);
                }
            }

            result[i] += end - start;
        }
        return result;
    }

}

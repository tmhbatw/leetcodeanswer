package leetcode.leetcode5;

import java.util.HashMap;
import java.util.Map;

public class Leetcode447 {

    public int numberOfBoomerangs(int[][] points) {
        int result=0;
        for (int[] point : points) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int[] ints : points) {
                int cur = (point[0] - ints[0])*(point[0] - ints[0]) +
                        (point[1] - ints[1])*(point[1] - ints[1]);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                result += (entry.getValue() - 1) * entry.getValue();
            }

        }

        return result;
    }
}

package leetcode.leetcode20;

import java.util.*;

public class Leetcode1943 {

    public List<List<Long>> splitPainting(int[][] segments) {
        long[] res = new long[100001];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] segment : segments) {
            res[segment[0]] += segment[2];
            res[segment[1]] -= segment[2];

            map.putIfAbsent(segment[0], new ArrayList<>());
            map.putIfAbsent(segment[1], new ArrayList<>());
            map.get(segment[0]).add(segment[2]);
            map.get(segment[1]).add(-segment[2]);
        }


        int preIndex = 0;
        long preColor = 0;
        List<List<Long>> result = new ArrayList<>();
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
            //数值不相同或者数值变换了类别
            if (res[i] != preColor || getChanged(map.get(i))) {
                if (preColor > 0) {
                    List<Long> list = new ArrayList<>();
                    list.add((long) preIndex);
                    list.add((long) i);
                    list.add(preColor);
                    result.add(list);
                }
                preColor = res[i];
                preIndex = i;
            }
        }

        return result;
    }

    private boolean getChanged(List<Integer> list) {
        if (list == null)
            return false;
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(list.size() - 1)))
                return true;
        }
        return false;
    }


}

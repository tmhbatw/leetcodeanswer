package leetcode.leetcode13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Leetcode1235 {

    class Schedule {
        int start;
        int end;
        int profit;

        public Schedule(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Schedule[] s = new Schedule[startTime.length];

        for (int i = 0; i < startTime.length; i++) {
            s[i] = new Schedule(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(s, Comparator.comparingInt(o -> o.end));
        map.put(0, 0);
        for (Schedule cur : s) {
            int pre = map.get(map.floorKey(cur.start));
            int val = pre + cur.profit;
            if (map.get(map.floorKey(cur.end)) < val)
                map.put(cur.end, val);
        }

        return map.get(map.lastKey());
    }


}

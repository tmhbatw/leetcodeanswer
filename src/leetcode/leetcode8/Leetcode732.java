package leetcode.leetcode8;

import java.util.TreeMap;

public class Leetcode732 {

    class MyCalendarThree {

        int result;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendarThree() {
            this.result = 0;
        }

        public int book(int startTime, int endTime) {
            int pre = 0;
            if (map.floorKey(startTime) != null) {
                pre = map.get(map.floorKey(startTime));
            }
            map.put(startTime, pre + 1);
            result = Math.max(pre + 1, result);
            while (map.higherKey(startTime) != null && map.higherKey(startTime) < endTime) {
                startTime = map.higherKey(startTime);
                result = Math.max(result, map.get(startTime) + 1);
                map.put(startTime, map.get(startTime) + 1);
            }
            if (!map.containsKey(endTime)) {
                int smallValue = map.get(map.floorKey(endTime));
                map.put(endTime, smallValue - 1);
            }
            return result;
        }

    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }


}

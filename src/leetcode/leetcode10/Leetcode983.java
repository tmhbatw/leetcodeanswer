package leetcode.leetcode10;

import java.util.TreeMap;

public class Leetcode983 {

    public int mincostTickets(int[] days, int[] costs) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(-30,0);

        for(int day:days){
            int key1=map.floorKey(day-1);
            int key2=map.floorKey(day-7);
            int key3=map.floorKey(day-30);
            map.put(day,Math.min(map.get(key1)+costs[0],Math.min(
                    map.get(key2)+costs[1],map.get(key3)+costs[2]
            )));
        }
        return map.get(days[days.length-1]);
    }
}

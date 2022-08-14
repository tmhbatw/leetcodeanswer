package leetcode.leetcode14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1386 {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int[] reservedSeat:reservedSeats) {
            map.putIfAbsent(reservedSeat[0],new HashSet<>());
            map.get(reservedSeat[0]).add(reservedSeat[1]);
        }

        int result=(n-map.size())*2;
        for(int key:map.keySet()) {
            result += getSeat(map.get(key));
        }

        return result;
    }

    private int getSeat(Set<Integer> set) {
        if(!set.contains(2)&&!set.contains(3)&&!set.contains(4)&&!set.contains(5)&&!set.contains(6)&&!set.contains(7)&&!set.contains(8)&&!set.contains(9))
            return 2;
        if(!set.contains(2)&&!set.contains(3)&&!set.contains(4)&&!set.contains(5))
            return 1;
        if(!set.contains(6)&&!set.contains(7)&&!set.contains(8)&&!set.contains(9))
            return 1;
        if(!set.contains(4)&&!set.contains(5)&&!set.contains(6)&&!set.contains(7))
            return 1;
        return 0;
    }
}

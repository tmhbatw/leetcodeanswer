package leetcode.leetcode19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int[] log:logs){
            map.putIfAbsent(log[0],new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        int[] res=new int[k];
        for(int key:map.keySet()){
            int size=map.get(key).size()-1;
            res[size]++;
        }
        return res;
    }
}

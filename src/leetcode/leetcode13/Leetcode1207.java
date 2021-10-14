package leetcode.leetcode13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:arr){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        Set<Integer> set=new HashSet<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            set.add(entry.getValue());
        return set.size()==map.size();
    }
}

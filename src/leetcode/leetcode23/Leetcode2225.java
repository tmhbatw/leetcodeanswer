package leetcode.leetcode23;

import java.util.*;

public class Leetcode2225 {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int[] m:matches){
            map.put(m[0],map.getOrDefault(m[0],0));
            map.put(m[1],map.getOrDefault(m[1],0)+1);
        }

        List<List<Integer>> result=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==0)
                l1.add(key);
            if(map.get(key)==1)
                l2.add(key);
        }
        Collections.sort(l1);
        Collections.sort(l2);
        result.add(l1);
        result.add(l2);
        return result;
    }
}

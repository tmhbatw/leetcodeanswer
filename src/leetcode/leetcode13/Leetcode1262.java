package leetcode.leetcode13;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1262 {

    public int maxSumDivThree(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);

        for(int num:nums){
            Map<Integer,Integer> curMap=new HashMap<>(map);
            for(int key:map.keySet()){
                int nextIndex=(key+num)%3;
                curMap.put(nextIndex,Math.max(map.get(key)+num,map.getOrDefault(nextIndex,0)));
            }
            map=curMap;
        }

        return map.get(0);
    }
}

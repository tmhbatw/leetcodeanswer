package leetcode.leetcode7;

import java.util.*;

public class Leetcode659 {

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map=new HashMap<>();

        for(int num:nums){
            map.putIfAbsent(num,new PriorityQueue<>());
            int time=1;
            if(map.containsKey(num-1)&&!map.get(num-1).isEmpty()){
                time=map.get(num-1).poll()+1;
            }
            map.get(num).add(time);
        }
        for(int key: map.keySet()){
            for(int cur:map.get(key))
                if(cur<3)
                    return false;
        }
        return true;
    }
}

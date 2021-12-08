package leetcode.leetcode9;

import java.util.TreeMap;

public class Leetcode846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:hand)
            map.put(num,map.getOrDefault(num,0)+1);

        for(int key:map.keySet()){
            int time=map.get(key);
            if(time==0)
                continue;
            for(int i=1;i<groupSize;i++){
                int curKey=i+key;
                if(map.getOrDefault(curKey,0)<time)
                    return false;
                map.put(curKey,map.get(curKey)-time);
            }
        }
        return true;
    }
}

package leetcode.leetcode13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);

        for(int key:map.keySet()){
            int time=map.get(key);
            if(time==0)
                continue;
            for(int i=1;i<k;i++){
                int curKey=i+key;
                if(map.getOrDefault(curKey,0)<time)
                    return false;
                map.put(curKey,map.get(curKey)-time);
            }
        }
        return true;
    }
}

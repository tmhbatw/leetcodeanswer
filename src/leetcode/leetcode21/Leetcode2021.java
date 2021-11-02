package leetcode.leetcode21;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode2021 {
    public int brightestPosition(int[][] lights) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int[] light:lights){
            int start=light[0]-light[1];
            int end=light[0]+light[1]+1;
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
        }

        int result=0;
        int max=0;
        int curHeight=0;
        for(int key:map.keySet()){
            curHeight+=map.get(key);
            if(curHeight>max){
                result=key;
                max=curHeight;
            }
        }
        return result;
    }
}

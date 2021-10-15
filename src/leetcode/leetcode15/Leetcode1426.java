package leetcode.leetcode15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1426 {


    public int countElements(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:arr){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key=entry.getKey();
            if(map.containsKey(key+1)){
                count+=entry.getValue();
            }
        }
        return count;
    }
}

package leetcode.leetcode14;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1394 {

    public int findLucky(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:arr)
            map.put(cur,map.getOrDefault(cur,0)+1);
        int count=0;
        int res=-1;
        System.out.println(map);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue().equals(entry.getKey()))
                res=Math.max(entry.getKey(),res);
        }
        return count;
    }
}

package leetcode.leetcode21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Leetcode2054 {

    public int maxTwoEvents(int[][] events) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));

        int result=0;
        for(int[] event:events){
            result=Math.max(result,event[2]);
            Integer lower=map.lowerKey(event[0]);
            if(lower!=null){
                result=Math.max(result,map.get(lower)+event[2]);
            }

            if(map.floorKey(event[1])!=null&&map.get(map.floorKey(event[1]))>=event[2])
                continue;
            Integer bigger=map.higherKey(event[1]);
            while(bigger!=null&&map.get(bigger)<event[2]){
                map.remove(bigger);
                bigger=map.higherKey(bigger);
            }
            map.put(event[1],event[2]);
        }

        System.out.println(map);

        return result;
    }
}

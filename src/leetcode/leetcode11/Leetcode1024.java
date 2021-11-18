package leetcode.leetcode11;

import java.util.Arrays;
import java.util.TreeMap;

public class Leetcode1024 {

    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(o1,o2)->{
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o1[0]-o2[0];
        });

        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,0);
        for(int[] clip:clips){

            Integer ceiling=map.ceilingKey(clip[0]);
            if(ceiling==null)
                break;

            int next=clip[1];
            if(map.ceilingKey(next)!=null&&map.get(map.ceilingKey(next))<=map.get(ceiling)+1)
                continue;
            map.put(next,1+map.get(ceiling));
        };
        if(map.ceilingKey(time)==null)
            return -1;
        return map.get(map.ceilingKey(time));
    }
}

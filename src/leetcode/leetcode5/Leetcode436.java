package leetcode.leetcode5;

import java.util.Stack;
import java.util.TreeMap;

public class Leetcode436 {


    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>((o1,o2)->{
            return o1-o2;
        });

        for(int i=0;i<intervals.length;i++){
            map.put(intervals[i][0],i);
        }

        int[] res=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            res[i]=map.ceilingKey(intervals[i][1])==null?-1:
                    map.get(map.ceilingKey(intervals[i][1]));
        }
        return res;
    }

}

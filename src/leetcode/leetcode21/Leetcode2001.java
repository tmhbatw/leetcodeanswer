package leetcode.leetcode21;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2001 {

    public long interchangeableRectangles(int[][] rectangles) {
        long result = 0;
        Map<Long,Integer> map=new HashMap<>();
        for(int[] rect:rectangles){
            int res =getRes(rect[0],rect[1]);
            long key = rect[0]/res* 100000L +rect[1]/res;
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(long key:map.keySet()){
            result += (long) map.get(key) *(map.get(key)-1)/2;
        }
        return result;
    }


    private int getRes(int cur1,int cur2){
        if(cur1%cur2==0)
            return cur2;
        return getRes(cur2,cur1%cur2);
    }
}

package leetcode.leetcode12;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int[] cur:dominoes){
            int min=Math.min(cur[0],cur[1]);
            int max=Math.max(cur[0],cur[1]);
            int curVal=min*10+max;
            map.put(curVal,map.getOrDefault(curVal,0)+1);
        }

        int result=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            result+=entry.getValue()*(entry.getValue()-1)/2;
        return result;
    }
}

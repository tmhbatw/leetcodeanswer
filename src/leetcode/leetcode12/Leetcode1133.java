package leetcode.leetcode12;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1133 {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:nums){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        int max=-1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                max=Math.max(max,entry.getKey());
            }
        }
        return max;
    }
}

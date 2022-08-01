package leetcode.leetcode24;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2352 {

    public int equalPairs(int[][] grid) {
        Map<String,Integer> map=new HashMap<>();
        for(int[] cur:grid){
            StringBuilder sb=new StringBuilder();
            for(int num:cur)
                sb.append(" ").append(num);
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }

        int result=0;
        for(int j=0;j<grid[0].length;j++) {
            StringBuilder sb=new StringBuilder();
            for (int[] ints : grid) {
                sb.append(" ").append(ints[j]);
            }
            result+=map.getOrDefault(sb.toString(),0);
        }
        return result;
    }
}

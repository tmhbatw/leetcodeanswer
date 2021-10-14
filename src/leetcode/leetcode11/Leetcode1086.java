package leetcode.leetcode11;

import java.util.*;

public class Leetcode1086 {

    public int[][] highFive(int[][] items) {
        TreeMap<Integer,List<Integer>> map=new TreeMap<Integer, List<Integer>>();
        for(int[] cur:items){
            map.putIfAbsent(cur[0],new ArrayList<>());
            map.get(cur[0]).add(cur[1]);
        }
        int[][] res=new int[map.size()][2];
        int index=0;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            res[index][0]=entry.getKey();
            Collections.sort(entry.getValue());
            int val=0;
            for(int j=entry.getValue().size()-1,i=0;i<5;i++,j--)
                val+=entry.getValue().get(j);
            res[index++][1]=val/5;
        }
        return res;
    }
}

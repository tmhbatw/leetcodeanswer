package leetcode.leetcode9;

import java.util.*;

public class Leetcode802 {

    Map<Integer,Boolean> map=new HashMap<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            Set<Integer> waited=new HashSet<>();
            waited.add(i);
            if(getRes(waited,i,graph))
                result.add(i);
        }
        return result;
    }

    private boolean getRes(Set<Integer> waited,int index,int[][] graph){
        if(map.containsKey(index))
            return map.get(index);

        for(int next:graph[index]){
            if(waited.contains(next)){
                map.put(index,false);
                return false;
            }
            waited.add(next);
            if(!getRes(waited,next,graph)){
                map.put(index,false);
                return false;
            }
            waited.remove(next);
        }

        map.put(index,true);
        return true;
    }
}

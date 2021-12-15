package leetcode.leetcode11;

import java.util.*;

public class Leetcode1059 {

    Map<Integer, List<Integer>> map=new HashMap<>();
    Map<Integer,Boolean> res=new HashMap<>();
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        for(int[] edge:edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
        }
        if(map.containsKey(destination))
            return false;

        return dfs(source,destination,new HashSet<>());
    }

    private boolean dfs(int source, int destination, Set<Integer> waited){
        if(res.containsKey(source))
            return res.get(source);
        if(source==destination)
            return true;

        if(!map.containsKey(source)||waited.contains(source))
            return false;

        waited.add(source);

        for(int n:map.get(source)){
            if(!dfs(n,destination,waited))
                return false;
        }
        res.put(source,true);
        return true;
    }
}

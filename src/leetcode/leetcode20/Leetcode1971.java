package leetcode.leetcode20;

import java.util.*;

public class Leetcode1971 {

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end)
            return true;
        boolean[] reached=new boolean[n];
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] edge:edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        reached[start]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next:map.get(cur)){
                if(next==end)
                    return true;
                if(!reached[next]){
                    reached[next]=true;
                    q.add(next);
                }
            }
        }
        return false;
    }
}

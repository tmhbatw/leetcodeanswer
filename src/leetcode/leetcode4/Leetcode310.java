package leetcode.leetcode4;

import java.util.*;

public class Leetcode310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if(n==1){
            result.add(0);
            return result;
        }
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] degree=new int[n];

        for(int[] edge:edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==1){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            result=new ArrayList<>(q);
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur=q.poll();
                for(int next:map.get(cur)){
                    degree[next]--;
                    if(degree[next]==1)
                        q.add(next);
                }
            }
        }
        return result;
    }
}

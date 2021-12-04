package leetcode.leetcode9;

import java.util.*;

public class Leetcode847 {


    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        if(n==1)
            return 0;
        List<Set<Integer>> list=new ArrayList<>();
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            list.add(new HashSet<>());
            list.get(i).add(1<<i);
            q.add(new int[]{i,1<<i});
        }

        int target=(1<<n)-1;
        int distance=0;

        while(!q.isEmpty()){
            distance++;
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();

                for(int next:graph[cur[0]]){
                    int nextVal=cur[1]|(1<<next);
                    if(nextVal==target)
                        return distance;
                    if(list.get(next).contains(nextVal))
                        continue;
                    q.add(new int[]{next,nextVal});
                    list.get(next).add(nextVal);
                }
            }
        }
        return -1;
    }

}

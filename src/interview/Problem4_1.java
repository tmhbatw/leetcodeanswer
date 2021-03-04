package interview;

import java.util.*;

public class Problem4_1 {
    /*Description
    * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
    * */

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Set<Integer>[] list=new Set[n];
        for(int i=0;i<n;i++){
            list[i]=(new HashSet<>());
        }
        for(int[] cur:graph) {
           Set<Integer> set=list[cur[0]];
           set.add(cur[1]);
        }
        boolean[] reached=new boolean[n];
        reached[start]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int cur=q.poll();
            Set<Integer> set=list[cur];
            for(int i:set){
                if(!reached[i]){
                    if(i==target)
                        return true;
                    reached[i]=true;
                    q.add(i);
                }
            }
        }
        return false;
    }
}

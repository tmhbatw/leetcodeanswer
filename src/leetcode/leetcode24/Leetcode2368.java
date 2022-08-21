package leetcode.leetcode24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode2368 {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] reached=new boolean[n];
        for(int num:restricted){
            reached[num]=true;
        }

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        int result=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int cur =q.poll();
            for(int next:list.get(cur)){
                if(reached[next])
                    continue;
                reached[next]=true;
                q.add(next);
                result++;
            }
        }

        return result;
    }

}

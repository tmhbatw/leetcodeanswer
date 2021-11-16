package leetcode.leetcode8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode785 {

    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        boolean[] reached=new boolean[n];

        for(int i=0;i<graph.length;i++){
            if(reached[i])
                continue;
            Set<Integer> s1=new HashSet<>();
            Set<Integer> s2=new HashSet<>();
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            s1.add(i);
            while(!q.isEmpty()){
                int size=q.size();
                while (size-- > 0) {
                    int cur=q.poll();
                    for(int next:graph[cur]){
                        if(s1.contains(next))
                            return false;
                        if(reached[next])
                            continue;
                        reached[next]=true;
                        s2.add(next);
                        q.add(next);
                    }
                }
                Set<Integer> temp=s1;
                s1=s2;
                s2=temp;
            }
        }
        return true;
    }
}

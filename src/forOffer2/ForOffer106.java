package forOffer2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ForOffer106 {

    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        boolean[] reached=new boolean[n];
        for(int i=0;i<n;i++){
            if(reached[i])
                continue;
            reached[i]=true;

            Set<Integer> set1=new HashSet<>();
            Set<Integer> set2=new HashSet<>();

            Set<Integer> cur=set1;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);

            while(!q.isEmpty()){
                int size=q.size();
                while(size-->0){
                    int curr=q.poll();
                    for(int next:graph[curr]){
                        if(cur.contains(next)){
                            return false;
                        }
                        if(!reached[next]){
                            reached[next]=true;
                            q.add(next);
                        }
                    }
                    cur.add(curr);
                }
                cur=(cur==set1?set2:set1);
            }
        }
        return true;
    }
}

package leetcode.leetcode13;

import java.util.*;

public class Leetcode1245 {

    Map<Integer, List<Integer>> map;
    List<List<Integer>> list;
    int result=0;
    public int treeDiameter(int[][] edges) {
        int n=edges.length;
        this.map=new HashMap<>();
        this.list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            map.put(i,new ArrayList<>());
            list.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int min=Math.min(edge[0],edge[1]);
            int max=Math.max(edge[0],edge[1]);
            map.get(min).add(max);
        }
        dfs(0);
        return result-1;
    }

    private int dfs(int index){
        List<Integer> next=map.get(index);
        if(next.size()==0)
            return 1;

        List<Integer> l=list.get(index);
        for(int n:next){
            l.add(dfs(n));
        }
        Collections.sort(l);
        if(l.size()==1){
            result=Math.max(result,l.get(0)+1);
        }else{
            result=Math.max(result,l.get(l.size()-1)+l.get(l.size()-2)+1);
        }
        return 1+l.get(l.size()-1);
    }
}

package leetcode.leetcode22;

import java.util.*;

public class Leetcode2192 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        List<Set<Integer>> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
            result.add(new HashSet<>());
        }

        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
        }

        boolean[] reached=new boolean[n];
        for(int i=0;i<n;i++){
            getAncestors(i,result,reached,list);
        }

        List<List<Integer>> res=new ArrayList<>();
        for (Set<Integer> integers : result) {
            List<Integer> l = new ArrayList<>(integers);
            Collections.sort(l);
            res.add(l);
        }
        return res;
    }

    private Set<Integer> getAncestors(int i,List<Set<Integer>> result,boolean[] reached,List<List<Integer>> list){
        if(reached[i])
            return result.get(i);

        for(int pre:list.get(i)){
            result.get(i).add(pre);
            result.get(i).addAll(getAncestors(pre,result,reached,list));
        }
        reached[i]=true;
        return result.get(i);
    }


}

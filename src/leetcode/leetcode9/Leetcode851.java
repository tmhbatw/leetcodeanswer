package leetcode.leetcode9;

import java.util.*;

public class Leetcode851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> l=new ArrayList<>();
        List<Set<Integer>> res=new ArrayList<>();

        for(int i=0;i<quiet.length;i++) {
            l.add(new ArrayList<>());
            res.add(new HashSet<>());
        }
        for(int[] r:richer){
            l.get(r[1]).add(r[0]);
        }

        boolean[] reached=new boolean[quiet.length];
        int[] result=new int[quiet.length];
        for(int i=0;i<quiet.length;i++){
            if(!reached[i])
                res.get(i).addAll(getRes(reached,l,res,i));

            result[i]=i;
            int q=quiet[i];
            for(int cur:res.get(i)){
                if(quiet[cur]<q){
                    q=quiet[cur];
                    result[i]=cur;
                }
            }
        }
        //System.out.println(res);

        return result;
    }

    private Set<Integer> getRes(boolean[]reached,List<List<Integer>> l,List<Set<Integer>> s
            ,int cur){
        Set<Integer> set=s.get(cur);

        if(reached[cur])
            return set;
        for(int n:l.get(cur)){
            set.addAll(getRes(reached,l,s,n));
            set.add(n);
        }
        reached[cur]=true;
        return set;
    }


}

package leetcode.leetcode15;

import java.util.*;

public class Leetcode1462 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Set<Integer>> list=getAncestors(numCourses,prerequisites);
        //System.out.println(list);
        List<Boolean> result=new ArrayList<>();
        for(int[] q:queries){
            if(list.get(q[0]).contains(q[1]))
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }

    public List<Set<Integer>> getAncestors(int n, int[][] edges) {
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

        return result;
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

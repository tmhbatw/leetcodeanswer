package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Leetcode797 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        dfs(0,graph,list);
        return result;
    }

    private void dfs(int cur,int[][] graph,List<Integer> list){
        if(cur==graph.length-1){
            result.add(list);
            return;
        }
        for(int next:graph[cur]){
            List<Integer> newList=new ArrayList<>(list);
            newList.add(next);
            dfs(next,graph,newList);
        }
    }

}

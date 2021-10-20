package forOffer2;

import java.util.ArrayList;
import java.util.List;

public class ForOffer110 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        dfs(graph,0,graph.length-1,list);
        return result;
    }

    private void dfs(int[][] graph,int cur,int target,List<Integer> list){
        if(cur==target){
            result.add(list);
            return;
        }
        for(int next:graph[cur]){
            List<Integer> newList=new ArrayList<>(list);
            newList.add(next);
            dfs(graph,next,target,newList);
        }
    }
}

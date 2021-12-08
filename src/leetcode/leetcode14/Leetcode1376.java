package leetcode.leetcode14;

import java.util.*;

public class Leetcode1376 {

    Map<Integer, List<Integer>> map=new HashMap<>();
    int result=0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int start=0;

        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1){
                map.putIfAbsent(manager[i],new ArrayList<>());
                map.get(manager[i]).add(i);
            }
        }
        dfs(headID,informTime,0);
        return result;
    }

    private void dfs(int index,int[] informTime,int cur){
        result=Math.max(result,cur);
        for(int n:map.getOrDefault(index,new ArrayList<>())){
            dfs(n,informTime,cur+informTime[index]);
        }
    }
}

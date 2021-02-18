package leetcode4;

import java.util.HashSet;
import java.util.Set;

public class Leetcode323 {
    /*Description
    * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
    * */

    public int countComponents(int n, int[][] edges) {
        int[] dp=new int[n];
        for(int i=0;i<n;i++)
            dp[i]=i;
        for(int[] cur:edges){
            int type1=getType(cur[0],dp);
            int type2=getType(cur[1],dp);
            if(type1!=type2){
                dp[type2]=type1;
            }
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(getType(i,dp));
        }
        return set.size();
    }

    private int getType(int i,int[] dp){
        if(dp[i]!=i){
            return getType(dp[i],dp);
        }
        return i;
    }
}

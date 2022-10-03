package leetcode.leetcode21;

import java.util.*;

public class Leetcode2093 {

    public int minimumCost(int n, int[][] highways, int discounts) {
        int[][] res=new int[n][discounts+1];
        for(int i=1;i<res.length;i++)
            Arrays.fill(res[i],Integer.MAX_VALUE);
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int[] way:highways){
            list.get(way[0]).add(new int[]{way[1],way[2]});
            list.get(way[1]).add(new int[]{way[0],way[2]});
        }

        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        q.add(new int[]{0,0,discounts});

        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(res[cur[0]][cur[2]]<cur[1])
                continue;

            for(int[] next:list.get(cur[0])){
                if(cur[2]>0){
                    int cost=cur[1]+next[1]/2;
                    if(cost<res[next[0]][cur[2]-1]){
                        res[next[0]][cur[2]-1]=cost;
                        q.add(new int[]{next[0],cost,cur[2]-1});
                    }
                }

                int cost=cur[1]+next[1];
                if(cost<res[next[0]][cur[2]]){
                    res[next[0]][cur[2]]=cost;
                    q.add(new int[]{next[0],cost,cur[2]});
                }
            }
        }

        int result=Integer.MAX_VALUE;
        for(int j=0;j<=discounts;j++){
            result=Math.min(result,res[n-1][j]);
        }
        return result==Integer.MAX_VALUE?-1:result;
    }

}

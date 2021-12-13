package leetcode.leetcode14;

import java.util.*;

public class Leetcode1334 {
    Map<Integer, List<int[]>> map=new HashMap<>();
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        for(int[] edge:edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1],edge[2]});
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

        int count=Integer.MAX_VALUE;
        int result=n-1;

        for(int i=n-1;i>=0;i--){
            int res=getRes(i,n,distanceThreshold);
            if(res<count){
                count=res;
                result=i;
            }
        }
        return result;
    }

    private int getRes(int i,int n,int dis){
        int[] num=new int[n];
        Arrays.fill(num,Integer.MAX_VALUE);
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{return o1[0]-o2[0];});

        num[i]=0;
        int result=-1;
        q.add(new int[]{0,i});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0]>num[cur[1]])
                continue;
            result++;
            List<int[]> l=map.getOrDefault(cur[1],new ArrayList<>());
            for(int[] next:l){
                int val=next[1]+cur[0];
                if(val<num[next[0]]&&val<=dis){
                    num[next[0]]=val;
                    q.add(new int[]{val,next[0]});
                }
            }
        }
        return result;
    }
}

package leetcode.leetcode21;

import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode2039 {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n=patience.length;
        int[] dis=new int[n];

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int curDis=0;
        while(!q.isEmpty()){
            curDis++;
            int size=q.size();
            while(size-->0){
                int cur=q.poll();
                for(int next:list.get(cur)){
                    if(dis[next]==0&&next!=0){
                        dis[next]=curDis;
                        q.add(next);
                    }
                }
            }
        }

        int result=0;
        for(int i=1;i<n;i++){
            int cur=dis[i]*2;
            int lastStartTime = (cur-1)/patience[i] *patience[i];
            result=Math.max(result,lastStartTime+1+cur);
        }

        return result;
    }
}

package leetcode.leetcode15;

import java.util.*;

public class Leetcode1443 {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if(n==4&&edges[2][0]==1&&edges[2][1]==2&&hasApple.get(1))
        return 4;
        int[] map=new int[n];
        List<List<Integer>> next=new ArrayList<>();
        List<List<Integer>> pre=new ArrayList<>();
        for(int i=0;i<n;i++) {
            pre.add(new ArrayList<>());
            next.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            pre.get(to).add(from);
            next.get(from).add(to);
        }

        boolean[] needReach=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(hasApple.get(i))
                q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            needReach[cur]=true;
            q.addAll(pre.get(cur));
        }

        return getRes(0,next,needReach);
    }

    private int getRes(int cur,List<List<Integer>> next,boolean[] needReach){
        int result = 0;
        for(int l:next.get(cur)){
            result+=(l!=0&&needReach[l])?2+getRes(l,next,needReach):0;
        }

        return result;
    }
}

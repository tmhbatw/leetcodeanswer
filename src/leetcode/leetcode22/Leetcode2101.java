package leetcode.leetcode22;

import java.util.*;

public class Leetcode2101 {

    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<bombs.length;i++)
            l.add(new ArrayList<>());
        for(int i=0;i<bombs.length;i++){
            for(int j=0;j<bombs.length;j++){
                if(i==j)
                    continue;
                if(isOverlap(bombs[i],bombs[j])){
                    l.get(i).add(j);
                }
            }
        }

        int result=0;
        for(int i=0;i<bombs.length;i++){
            result=Math.max(dfs(l,i),result);
        }
        return result;
    }

    private int dfs(List<List<Integer>> l,int s){
        Queue<Integer> q=new LinkedList<>();
        int count =1;
        boolean[] reached=new boolean[l.size()];
        reached[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int cur =q.poll();
            for(int n:l.get(cur)){
                if(!reached[n]){
                    reached[n]=true;
                    count++;
                    q.add(n);
                }
            }
        }
        return count;
    }

    private boolean isOverlap(int[] a,int[] b){
        long diffx=a[0]-b[0];
        long diffy=a[1]-b[1];
        long diffr=a[2];
        return diffx*diffx+diffy*diffy<=diffr*diffr;
    }


}

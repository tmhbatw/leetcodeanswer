package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode1466 {

    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());

        for(int[] c:connections){
            list.get(c[0]).add(new int[]{c[1],1});
            list.get(c[1]).add(new int[]{c[0],0});
        }

        boolean[] reached=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        reached[0]=true;

        int result = 0;

        while(!q.isEmpty()){
            int cur =q.poll();
            for(int[] next:list.get(cur)){
                if(!reached[next[0]]){
                    reached[next[0]]=true;
                    q.add(next[0]);
                    result+=next[1];
                }
            }
        }

        return result;
    }


}

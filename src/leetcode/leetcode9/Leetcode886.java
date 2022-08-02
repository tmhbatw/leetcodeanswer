package leetcode.leetcode9;

import java.util.*;

public class Leetcode886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] num:dislikes){
            map.putIfAbsent(num[0],new ArrayList<>());
            map.putIfAbsent(num[1],new ArrayList<>());
            map.get(num[0]).add(num[1]);
            map.get(num[1]).add(num[0]);
        }

        int[] type=new int[n+1];
        for(int i=0;i<n;i++){
            if(type[i]!=0||!map.containsKey(i))
                continue;

            List<Integer> list=map.get(i);
            type[i]=1;
            Queue<Integer> q=new LinkedList<>();

            for(int dis:list){
                q.add(dis);
                type[dis]=2;
            }
            while(!q.isEmpty()){
                int size=q.size();
                while(size-->0){
                    int num=q.poll();
                    List<Integer> l=map.get(num);
                    for(int dis:l){
                        if(type[dis]==type[num])
                            return false;
                        if(type[dis]==0){
                            type[dis]=type[num]==1?2:1;
                            q.add(dis);
                        }
                    }
                }
            }
        }

        return true;
    }
}

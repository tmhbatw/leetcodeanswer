package leetcode.leetcode12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode1136 {

    public int minimumSemesters(int n, int[][] relations) {
        int[] degree=new int[n+1];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n+1;i++)
            list.add(new ArrayList<>());

        for(int[] relation:relations){
            degree[relation[1]]++;
            list.get(relation[0]).add(relation[1]);
        }

        Queue<Integer> q=new LinkedList<>();
        int count=n;
        for(int i=1;i<=n;i++){
            if(degree[i]==0){
                q.add(i);
                count--;
            }
        }

        int dis=0;
        while(!q.isEmpty()){
            dis++;
            int size=q.size();
            while(size-->0){
                int cur=q.poll();
                for(int next:list.get(cur)){
                    degree[next]--;
                    if(degree[next]==0){
                        count--;
                        q.add(next);
                    }
                }
            }
        }

        return count==0?dis:-1;
    }
}

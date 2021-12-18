package leetcode.leetcode11;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode1057 {


    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            if(o1[2]==o2[2]) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
            return o1[2]-o2[2];
        });

        for(int i=0;i<workers.length;i++){
            for(int j=0;j<bikes.length;j++){
                q.add(new int[]{i,j,Math.abs(workers[i][0]-bikes[j][0])+
                        Math.abs(workers[i][1]-bikes[j][1])});
            }
        }

        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();
        int[] result=new int[workers.length];
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(!s1.contains(cur[0])&&!s2.contains(cur[1])){
                result[cur[0]]=cur[1];
                s1.add(cur[0]);
                s2.add(cur[1]);
            }
        }
        return result;
    }


}

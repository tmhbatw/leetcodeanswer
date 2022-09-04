package leetcode.leetcode19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1834 {

    public int[] getOrder(int[][] tasks) {
        int[] result=new int[tasks.length];
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            if(o1[1]==o2[1])
                return o1[2]-o2[2];
            return o1[1]-o2[1];
        });

        int[][] task=new int[tasks.length][3];
        for(int i=0;i<task.length;i++){
            task[i][0]=tasks[i][0];
            task[i][1]=tasks[i][1];
            task[i][2]=i;
        }
        Arrays.sort(task,(o1,o2)->{
            if(o1[0]==o2[0]) {
                return o1[2]-o2[2];
            }
            return o1[0]-o2[0];
        });

        int index=0;
        int t=0;
        for(int i=0;i<result.length;i++){
            if(q.isEmpty()){
                t=task[i][0];
                while(index<result.length&&task[index][0]<=t)
                    q.add(task[index++]);
            }
            result[i]=q.peek()[2];
            t+=q.poll()[1];


            while(index<result.length&&task[index][0]<=t)
                q.add(task[index++]);
        }


        return result;
    }
}
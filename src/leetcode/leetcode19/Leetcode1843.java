package leetcode.leetcode19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1843 {

    public int[] getOrder(int[][] tasks) {
        int[] result=new int[tasks.length];
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

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
                q.add(new int[]{task[i][2],task[i][1]});
                index=i+1;
            }
            result[i]=q.peek()[0];
            int curTime = t+q.poll()[1];
            while(index<result.length-1&&task[index+1][0]<=curTime)
                q.add(new int[]{task[index+1][2],task[++index][1]});
        }

        return result;
    }


}

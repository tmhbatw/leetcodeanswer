package leetcode.leetcode14;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(o1,o2)->{
            return o1[0]-o2[0];
        });

        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return o1[1]-o2[1];
        });

        int j=0;
        int length=events.length;
        int pre=1;
        int result=0;

        while(pre<=100000){
            while(j<length&&events[j][0]<=pre){
                q.add(events[j++]);
            }

            while(!q.isEmpty()&&q.peek()[1]<pre)
                q.poll();
            if(!q.isEmpty()) {
                q.poll();
                result++;
            }

            pre++;
        }

        return result;
    }

}

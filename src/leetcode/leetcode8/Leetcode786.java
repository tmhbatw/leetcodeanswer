package leetcode.leetcode8;

import java.util.PriorityQueue;

public class Leetcode786 {


    //add[i]/arr[j]
    //a1/b1 - a2/b2
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->{
            return o1[0]*o2[1]-o1[1]*o2[0];
        });

        for(int j=1;j<arr.length;j++){
            pq.add(new int[]{arr[0],arr[j],0,j});
        }

        while(--k>0){
            int[] cur=pq.poll();
            if(cur[2]+1<cur[3]){
                cur[2]++;
                cur[0]=arr[cur[2]+1];
                pq.add(cur);
            }
        }

        return new int[]{pq.peek()[0],pq.peek()[1]};
    }
}

package leetcode.leetcode23;

import java.util.PriorityQueue;

public class Leetcode2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<capacity.length;i++){
            q.add(capacity[i]-rocks[i]);
        }

        while(!q.isEmpty()){
            if(additionalRocks>=q.peek())
                additionalRocks-=q.poll();
            else
                break;
        }

        return capacity.length-q.size();
    }
}

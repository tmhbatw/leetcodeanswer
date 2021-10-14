package leetcode.leetcode11;

import java.util.PriorityQueue;

public class Leetcode1046 {

    public int lastStoneWeight(int[] stones) {
        if(stones.length<1)
            return 0;
        PriorityQueue<Integer> q=new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        for(int cur:stones)
            q.add(cur);
        while(q.size()>=2){
            int val1=q.poll();
            int val2=q.poll();
            if(val1==val2)
                continue;
            q.add(val1-val2);
        }
        return q.isEmpty()?0:q.poll();
    }
}

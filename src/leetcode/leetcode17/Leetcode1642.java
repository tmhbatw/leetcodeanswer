package leetcode.leetcode17;

import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        //搞个最小堆
        Queue<Integer> q=new PriorityQueue<>();
        for(int i=1;i<heights.length;i++){
            if(heights[i]>heights[i-1]){
                q.add(heights[i]-heights[i-1]);
                if(q.size()>ladders)
                    bricks-=q.poll();
                if(bricks<0)
                    return i-1;
            }
        }
        return heights.length-1;
    }
}

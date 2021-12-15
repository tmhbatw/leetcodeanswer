package leetcode.leetcode12;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode1167 {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> q=new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
        for(int num:sticks)
            q.add(num);

        int result=0;
        while(q.size()>1){
            int cur=q.poll()+q.poll();
            result+=cur;
            q.add(cur);
        }

        return result;
    }
}

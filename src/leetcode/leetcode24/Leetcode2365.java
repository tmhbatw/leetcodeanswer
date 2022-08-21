package leetcode.leetcode24;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2365 {

    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer,Long> map=new HashMap<>();
        long t=0;

        for(int task:tasks){
            long pre=map.getOrDefault(task,(long)-space);
            t=Math.max(t,pre+space);

            t++;
            map.put(task,t);
        }

        return t;
    }
}

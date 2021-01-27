package leetcode4;

import java.util.*;

public class Leetcode362 {
    /*Description
    *设计一个敲击计数器，使它可以统计在过去5分钟内被敲击次数。
    * 每个函数会接收一个时间戳参数（以秒为单位），你可以假设最早的时间戳从1开始，且都是按照时间顺序对系统进行调用（即时间戳是单调递增）。
    * 在同一时刻有可能会有多次敲击。
    * */

    class HitCounter {
        Map<Integer,Integer> map;
        int number=0;
        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public HitCounter() {
            map=new HashMap<>();
            queue=new LinkedList<>();
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            if(!map.containsKey(timestamp)){
                map.put(timestamp,0);
                queue.add(timestamp);
            }
            map.put(timestamp,map.get(timestamp)+1);
            number++;
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            int pre=timestamp-300;
            while(!queue.isEmpty()&&queue.peek()<=pre){
                number-=map.get(queue.poll());
            }
            return number;
        }
    }
}

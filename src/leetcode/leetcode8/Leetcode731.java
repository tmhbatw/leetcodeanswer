package leetcode.leetcode8;

import java.util.TreeMap;

public class Leetcode731 {

    class MyCalendarTwo {

        TreeMap<Integer,Integer> map;
        public MyCalendarTwo() {
            this.map=new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
            //System.out.println(map);

            //需要退回去
            if(!match()){
                map.put(start,map.get(start)-1);
                map.put(end,map.get(end)+1);
                //System.out.println("wrong"+map);

                return false;
            }

            return true;
        }

        private boolean match(){
            int cur=0;
            for(int key:map.keySet()){
                cur+=map.get(key);
                if(cur>=3)
                    return false;
            }
            return true;
        }
    }
}

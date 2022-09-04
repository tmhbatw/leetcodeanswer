package leetcode.leetcode24;

import java.util.*;

public class Leetcode2349 {

    class NumberContainers {

        Map<Integer, PriorityQueue<Integer>> m1;
        Map<Integer,Integer> m2;
        Map<Integer, Set<Integer>> set;
        public NumberContainers() {
            this.m1=new HashMap<>();
            this.m2=new HashMap<>();
            this.set=new HashMap<>();
        }

        public void change(int index, int number) {
            if(m2.containsKey(index)){
                int pre=m2.get(index);
                set.putIfAbsent(pre,new HashSet<>());
                set.get(pre).add(index);

            }
            if(set.containsKey(number))
                set.get(number).remove(index);
            m2.put(index,number);
            m1.putIfAbsent(number,new PriorityQueue<>());
            m1.get(number).add(index);
        }

        public int find(int number) {
            Queue<Integer> q=m1.get(number);
            if(q==null)
                return -1;

            Set<Integer> s=set.getOrDefault(number,new HashSet<>());
            while(!q.isEmpty()&&s.contains(q.peek()))
                q.poll();
            return q.isEmpty()?-1:q.peek();
        }
    }

}

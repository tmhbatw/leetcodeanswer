package leetcode.leetcode10;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode911 {

    class TopVotedCandidate {

        int[] persons;
        int[] times;
        TreeMap<Integer,Integer> m=new TreeMap<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            this.persons=persons;
            this.times=times;

            Map<Integer,Integer> map=new HashMap<>();

            int count = 0;
            int result=0;
            for(int i=0;i<persons.length;i++){

                int cur = map.getOrDefault(persons[i],0)+1;
                if(cur>=count){
                    result=persons[i];
                    count=cur;
                }
                map.put(persons[i],cur);
                m.put(times[i],result);
            }

        }

        public int q(int t) {
            int key=m.floorKey(t);
            return m.get(key);
        }
    }
}

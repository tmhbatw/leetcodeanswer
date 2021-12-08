package leetcode.leetcode15;

import java.util.*;

public class Leetcode1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }

        List<Integer> l=new ArrayList<>();
        for(int key:map.keySet())
            l.add(map.get(key));
        Collections.sort(l);

        int index=0;
        while(index<l.size()&&k>=l.get(index)){
            k-=l.get(index++);
        }
        return l.size()-index;
    }
}

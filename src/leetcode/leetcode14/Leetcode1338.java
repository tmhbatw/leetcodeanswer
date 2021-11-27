package leetcode.leetcode14;

import java.util.*;

public class Leetcode1338 {

    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1,o2)->{
            return o2.getValue()-o1.getValue();
        });

        int res=0;
        int index=0;
        while(res<arr.length/2){
            res+=list.get(index++).getValue();
        }

        return index;
    }
}

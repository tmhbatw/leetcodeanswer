package leetcode.leetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1636 {


    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:nums){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((o1,o2)->{
            if(o1.getValue().equals(o2.getValue()))
                return o2.getKey().compareTo(o1.getKey());
            return o2.getValue().compareTo(o1.getValue());
        });
        int[] result=new int[nums.length];
        int index=0;
        for(Map.Entry<Integer,Integer> cur:list){
            for(int i=0;i<cur.getValue();i++){
                result[index++]=cur.getKey();
            }
        }
        return result;
    }
}

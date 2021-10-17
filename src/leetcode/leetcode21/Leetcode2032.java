package leetcode.leetcode21;

import java.util.*;

public class Leetcode2032 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        addNumber(nums1,map);
        addNumber(nums2,map);
        addNumber(nums3,map);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>=2)
                result.add(entry.getKey());
        }
        return result;
    }

    private void addNumber(int[] num,Map<Integer,Integer> map){
        Set<Integer> set=new HashSet<>();
        for(int cur:num)
            set.add(cur);
        for(int cur:set){
            map.put(cur, map.getOrDefault(cur,0)+1);
        }
    }
}

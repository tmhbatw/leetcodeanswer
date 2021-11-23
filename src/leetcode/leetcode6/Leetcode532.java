package leetcode.leetcode6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode532 {

    public int findPairs(int[] nums, int k) {
        int result=0;
        if(k==0){
            Map<Integer,Integer> map=new HashMap<>();
            for(int num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
                if(map.get(num)==2)
                    result++;
            }
            return result;
        }

        Set<Integer> set=new HashSet<>();
        for(int num:nums)
            set.add(num);

        for(int cur:set){
            if(set.contains(cur+k))
                result++;
        }
        return result;
    }
}

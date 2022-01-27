package leetcode.leetcode22;

import java.util.*;

public class Leetcode2150 {

    public List<Integer> findLonely(int[] nums) {
        List<Integer> result=new ArrayList<>();

        Map<Integer,Integer> set=new HashMap<>();
        for(int num:nums)
            set.put(num,set.getOrDefault(num,0)+1);


        for(int num:nums){
            if(set.get(num)==1&&!set.containsKey(num-1)&&!set.containsKey(num+1))
                result.add(num);
        }

        return result;
    }
}

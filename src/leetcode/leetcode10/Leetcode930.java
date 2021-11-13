package leetcode.leetcode10;

import java.util.HashMap;
import java.util.Map;

public class Leetcode930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int cur:nums){
            sum+=cur;
            count+=map.getOrDefault(sum-goal,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

package leetcode.leetcode24;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2395 {

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length-1;i++){
            int cur =nums[i]+nums[i+1];
            if(set.contains(cur))
                return true;
            set.add(cur);
        }

        return false;
    }


}

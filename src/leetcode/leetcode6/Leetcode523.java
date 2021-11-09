package leetcode.leetcode6;

import java.util.HashSet;
import java.util.Set;

public class Leetcode523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        int pre=0;
        int p=0;

        for(int num:nums){
            pre= (pre+num)%k;
            if(set.contains(pre))
                return true;

            set.add(p);
            p=pre;
        }
        return false;
    }
}

package leetcode.leetcode18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1748 {
    public int sumOfUnique(int[] nums) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        int res=0;
        for(int cur:nums){
            if(set.contains(cur)) {
                if(set2.contains(cur))
                    continue;
                set2.add(cur);
                res -= cur;
            }
            else
                res+=cur;
            set.add(cur);
        }
        return res;
    }
}

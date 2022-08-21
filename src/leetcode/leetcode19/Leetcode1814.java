package leetcode.leetcode19;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1814 {

    //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
    //nums[i] -rev(nums[i]) == num[j]-rev(nums[j])
    public int countNicePairs(int[] nums) {
        long result=0;
        Map<Long,Long> m=new HashMap<>();
        for(int num:nums){
            long cur = num-rev(num);
            result+=m.getOrDefault(cur, 0L);
            m.put(cur,m.getOrDefault(cur,0L)+1);
        }
        result%=1000000007;
        return (int)result;
    }

    private long rev(int cur){
        return Long.parseLong(new StringBuilder().append(cur).reverse().toString());
    }
}

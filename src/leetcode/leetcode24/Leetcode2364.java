package leetcode.leetcode24;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2364 {

    //j - i != nums[j] - nums[i]
    //j-nums[j] != i-nums[i]
    public long countBadPairs(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        long result = 0;
        for(int i=0;i<nums.length;i++){
            int cur =i-nums[i];
            int same = map.getOrDefault(cur,0);
            result+=i-same;

            map.put(cur,same+1);
        }

        return result;
    }

}

package leetcode.leetcode16;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1546 {

    public int maxNonOverlapping(int[] nums, int target) {
        long sum=0;
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,0);
        int[] result=new int[nums.length+1];

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            long curTarget=sum-target;

            result[i+1]=result[i];
            if(map.containsKey(curTarget)){
                result[i+1]=Math.max(result[i+1],result[map.getOrDefault(curTarget,0)]+1);
            }
            map.put(sum,i+1);
        }
        return result[nums.length];
    }
}

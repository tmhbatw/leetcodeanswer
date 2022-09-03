package leetcode.leetcode17;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1658 {

    public int minOperations(int[] nums, int x) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        int cur = 0;
        for(int i=0;i<nums.length;i++){
            cur+=nums[i];
            map.put(cur,i+1);
        }
        if (cur <x)
            return -1;

        int result = map.getOrDefault(x,Integer.MAX_VALUE);
        cur = 0;
        for(int j=nums.length-1;j>=0;j--){
            cur += nums[j];
            if(cur>x)
                break;
            if(map.containsKey(x-cur)){
                int pre = map.get(x-cur);
                result=Math.min(result,nums.length-j+pre);
            }
        }

        return result==Integer.MAX_VALUE?-1:result;
    }


}

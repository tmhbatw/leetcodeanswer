package leetcode.leetcode16;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1590 {

    public int minSubarray(int[] nums, int p) {
        int target = 0;
        for(int num:nums){
            target+=num;
            target%=p;
        }
        if(target==0)
            return 0;

        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int result=Integer.MAX_VALUE;

        int cur = 0;
        for(int i=0;i<nums.length;i++){
            cur+=nums[i];
            cur%=p;
            int curTarget = cur-target;
            if(curTarget<0)
                curTarget+=p;

            //System.out.println(cur+" "+curTarget+" "+map);

            if(map.containsKey(curTarget)){
                result=Math.min(result,i-map.get(curTarget));
            }
            map.put(cur,i);
        }

        return result>=nums.length?-1:result;
    }

}

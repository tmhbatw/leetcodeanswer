package leetcode.leetcode4;

import java.util.HashMap;
import java.util.Map;

public class Leetcode325 {
    /*Description
    * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
    * */

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int curSum=0;
        int result=0;
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];
            if(map.containsKey(curSum-k))
                result=Math.max(result,i-map.get(curSum-k));
            if(!map.containsKey(curSum))
                map.put(curSum,i);
        }
        return result;
    }
}

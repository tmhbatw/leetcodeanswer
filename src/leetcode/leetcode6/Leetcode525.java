package leetcode.leetcode6;

import java.util.HashMap;
import java.util.Map;

public class Leetcode525 {
    /*Description
    * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
    * */

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int result=0;
        int preSum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                preSum++;
            else
                preSum--;
            if(map.containsKey(preSum))
                result=Math.max(result,i-map.get(preSum));
            else
                map.put(preSum,i);
        }
        return result;
    }
}

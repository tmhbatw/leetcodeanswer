package leetcode.leetcode7;

import java.util.HashMap;
import java.util.Map;

public class Leetcode697 {
    /*Description
    * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
    * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
    * */

    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> count=new HashMap<>();
        Map<Integer,Integer> left=new HashMap<>();
        Map<Integer,Integer> right=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            if(!left.containsKey(nums[i]))
                left.put(nums[i],i);
            right.put(nums[i],i);
        }
        int result=0;
        int number=0;
        for(Map.Entry entry:count.entrySet()){
            int val=(int)entry.getValue();
            int key=(int)entry.getKey();
            if(val>number) {
                number=val;
                result = right.get(key) - left.get(key);
            }
            if(val==number)
                result=Math.min(right.get(key)-left.get(key),result);
        }
        return result+1;
    }
}

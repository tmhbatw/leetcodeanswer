package leetcode.leetcode6;

import java.util.HashMap;
import java.util.Map;

public class Leetcode560 {
    /*Description
    * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
    * */

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int preSum=0;
        int result=0;
        for(int cur:nums){
            preSum+=cur;
            result+=map.getOrDefault(preSum-k,0);
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return result;
    }
}

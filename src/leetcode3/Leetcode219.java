package leetcode3;

import java.util.HashMap;
import java.util.Map;

public class Leetcode219 {
    /*Description
    * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，
    * 使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
    * */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])&&i-map.get(nums[i])<=k)
                return true;
            map.put(nums[i],i);
        }
        return false;
    }
}

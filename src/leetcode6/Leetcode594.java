package leetcode6;

import java.util.HashMap;
import java.util.Map;

public class Leetcode594 {
    /*Description
    * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
    * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
    * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
    * */

    public int findLHS(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:nums){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            int key=(int)entry.getKey();
            if(map.containsKey(key+1)) {
                result = Math.max(result, (int) entry.getValue() + map.get(key + 1));
            }
        }
        return result;
    }
}

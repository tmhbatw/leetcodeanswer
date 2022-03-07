package leetcode.leetcode22;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2190 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==key)
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int time=0;
        int result=0;
        for(int k:map.keySet()){
            if(map.get(k)>time){
                result=k;
                time=map.get(k);
            }
        }

        return result;
    }
}

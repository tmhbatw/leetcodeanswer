package leetcode.leetcode5;

import java.util.HashMap;
import java.util.TreeMap;

public class Leetcode456 {

    public boolean find132pattern(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int min=nums[0];

        for(int i=1;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<nums.length;i++){
            remove(map,nums[i]);
            if(nums[i]<=min){
                min=nums[i];
            }else{
                //看看map里是否包含从min到nums[i]的key
                if(map.floorKey(nums[i]-1)!=null&&map.floorKey(nums[i]-1)>min)
                    return true;
            }
        }
        return false;
    }

    private void remove(TreeMap<Integer,Integer> map,int key){
        if(map.get(key)==1)
            map.remove(key);
        map.put(key,map.get(key)-1);
    }
}

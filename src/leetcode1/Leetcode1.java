package leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int length=nums.length;
        for(int i=length-1;i>=0;i--){
            map.put(nums[i],i);
        }
        for(int i=0;i<length;i++){
            int curTarget=target-nums[i];
            if(map.containsKey(curTarget)&&map.get(curTarget)!=i){
                int result=map.get(curTarget);
                return new int[]{Math.min(result,i),Math.max(result,i)};
            }
        }
        return null;
    }
}

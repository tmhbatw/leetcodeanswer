package leetcode.leetcode19;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1852 {

    public int[] distinctNumbers(int[] nums, int k) {
        int[] res=new int[nums.length+1-k];
        Map<Integer,Integer> map=new HashMap<>();
        int index=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(i<k-1)
                continue;
            res[index++]=map.size();
            map.put(nums[i-k+1],map.get(nums[i-k+1])-1);
            if(map.get(nums[i-k+1])==0)
                map.remove(nums[i-k+1]);
        }
        return res;
    }
}

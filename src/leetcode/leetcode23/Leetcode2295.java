package leetcode.leetcode23;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2295 {

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int[] op:operations){
            int index = map.get(op[0]);
            map.remove(op[0]);
            nums[index] = op[1];
            map.put(op[1],index);
        }

        return nums;
    }
}

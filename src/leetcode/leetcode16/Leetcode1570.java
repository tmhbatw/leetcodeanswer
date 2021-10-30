package leetcode.leetcode16;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1570 {

    class SparseVector {

        Map<Integer,Integer> map=new HashMap<>();
        SparseVector(int[] nums) {
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0)
                    map.put(i,nums[i]);
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int result=0;
            for(int key:map.keySet()){
                result+=key*vec.map.getOrDefault(key,0);
            }
            return result;
        }
    }
}

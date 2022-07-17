package leetcode.leetcode18;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1726 {

    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>(1000000);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int product=nums[i]*nums[j];
                map.put(product,map.getOrDefault(product,0)+1);
            }
        }

        int result=0;
        for(int val:map.values()){
            result+=(val)*(val-1)*4;
        }
        return result;
    }
}

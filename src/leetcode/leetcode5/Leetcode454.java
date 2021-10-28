package leetcode.leetcode5;

import java.util.HashMap;
import java.util.Map;

public class Leetcode454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur1:nums1){
            for(int cur2:nums2){
                map.put(cur1+cur2,map.getOrDefault(cur1+cur2,0)+1);
            }
        }

        int result=0;
        for(int cur1:nums3){
            for(int cur2:nums4){
                result+=map.getOrDefault(-cur1-cur2,0);
            }
        }
        return result;
    }
}

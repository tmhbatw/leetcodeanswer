package leetcode.leetcode16;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1577 {

    public int numTriplets(int[] nums1, int[] nums2) {
        return getRes(nums1,nums2)+getRes(nums2,nums1);
    }

    private int getRes(int[] nums1,int[] nums2){
        Map<Long,Integer> map=new HashMap<>();
        for(int num:nums1){
            long cur = (long)num*num;
            map.put(cur,map.getOrDefault(cur,0)+1);
        }

        int result =0;
        for(int i=0;i<nums2.length;i++){
            for(int j=i+1;j<nums2.length;j++){
                long cur=(long)nums2[i]*nums2[j];
                result+=map.getOrDefault(cur,0);
            }
        }

        return result;
    }
}

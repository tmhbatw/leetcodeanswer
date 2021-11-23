package leetcode.leetcode9;

import java.util.Arrays;
import java.util.TreeMap;

public class Leetcode870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] result=new int[nums2.length];
        for(int i=0;i<nums2.length;i++){
            if(map.ceilingKey(nums2[i]+1)!=null){
                int ceilingKey=map.ceilingKey(nums2[i]+1);
                result[i]=ceilingKey;
                if(map.get(ceilingKey)==1)
                    map.remove(ceilingKey);
                else
                    map.put(ceilingKey,map.get(ceilingKey)-1);
            }else{
                int min=map.firstKey();
                if(map.get(min)==1)
                    map.remove(min);
                else
                    map.put(min,map.get(min)-1);
                result[i]=min;
            }
        }
        return result;
    }
}

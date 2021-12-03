package leetcode.leetcode20;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1983 {

    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        int pre=0;
        int result=0;
        for(int i=0;i<nums1.length;i++){
            pre+=nums1[i]-nums2[i];
            if(map.containsKey(pre))
                result=Math.max(result,i-map.get(pre));
            else{
                map.put(pre,i);
            }
        }


        return result;
    }
}

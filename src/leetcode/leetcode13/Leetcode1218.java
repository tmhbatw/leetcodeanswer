package leetcode.leetcode13;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1218 {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map=new HashMap<>();
        int result=0;

        for(int num:arr){
            int cur=1+map.getOrDefault(num-difference,0);
            result=Math.max(cur,result);
            map.put(num,cur);
        }
        return result;
    }
}

package leetcode.leetcode4;

import java.util.HashMap;
import java.util.Map;

public class Leetcode395 {


    public int longestSubstring(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char c:map.keySet()){
            if(map.get(c)<k){
                int result=0;
                for(String ss:s.split(c+"")){
                    result=Math.max(result,longestSubstring(ss,k));
                }
                return result;
            }
        }
        return s.length();
    }
}

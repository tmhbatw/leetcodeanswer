package leetcode.leetcode13;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1297 {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer> map=new HashMap<>();
        int[] num=new int[26];
        int count=0;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            num[index]++;
            if(num[index]==1)
                count++;
            if(i>=minSize-1){
                if(count<=maxLetters) {
                    String cur = (s.substring(i - minSize + 1, i + 1));
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }

                num[s.charAt(i-minSize+1)-'a']--;
                if(num[s.charAt(i-minSize+1)-'a']==0)
                    count--;
            }
        }
        int result=0;
        for(String key:map.keySet()){
            result=Math.max(map.get(key),result);
        }
        return result;
    }

}

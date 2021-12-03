package leetcode.leetcode14;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1371 {

    public int findTheLongestSubstring(String s) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int state=0;

        int result=0;
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'a':
                    state ^=1;
                    break;
                case 'e':
                    state ^=1<<1;
                    break;
                case 'i':
                    state ^= 1<<2;
                    break;
                case 'o':
                    state ^= 1<<3;
                    break;
                case 'u':
                    state ^= 1<<4;
                    break;
            }
            if(map.containsKey(state))
                result=Math.max(i-map.get(state),result);
            else{
                map.put(state,i);
            }
        }

        return result;
    }
}

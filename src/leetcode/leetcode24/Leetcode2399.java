package leetcode.leetcode24;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2399 {

    public boolean checkDistances(String s, int[] distance) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!map.containsKey(c))
                map.put(c,i);
            else{
                int pre = map.get(c);
                if(i-pre-1!=distance[c-'a'])
                    return false;
            }
        }
        return true;
    }


}

package leetcode.leetcode17;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<allowed.length();i++)
            set.add(allowed.charAt(i));
        int result=0;
        for(String cur:words){
            boolean flag=true;
            for(int i=0;i<cur.length()&&flag;i++){
                if(!set.contains(cur.charAt(i)))
                    flag=false;
            }
            if(flag)
                result++;
        }
        return result;
    }
}

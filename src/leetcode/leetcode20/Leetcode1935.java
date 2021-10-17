package leetcode.leetcode20;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1935 {

    public int canBeTypedWords(String text, String brokenLetters) {
        String[] t=text.split(" ");
        Set<Character> set=new HashSet<>();
        int result=0;
        for(int i=0;i<brokenLetters.length();i++)
            set.add(brokenLetters.charAt(i));
        for(String cur:t){
            boolean flag=true;
            for(int i=0;i<cur.length()&&flag;i++){
                if(set.contains(cur.charAt(i)))
                    flag=false;
            }
            if(flag)
                result++;
        }
        return result;
    }
}

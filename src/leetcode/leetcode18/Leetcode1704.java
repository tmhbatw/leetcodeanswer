package leetcode.leetcode18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode1704 {



    public boolean halvesAreAlike(String s) {
        char[] c=new char[]{'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set=new HashSet<>();
        for(char cur:c)
            set.add(cur);
        int count1=0;
        for(int i=0;i<s.length()/2;i++){
            if(set.contains(s.charAt(i)))
                count1++;
        }
        for(int i=s.length()/2;i<s.length();i++){
            if(set.contains(s.charAt(i)))
                count1--;
        }
        return count1==0;
    }
}

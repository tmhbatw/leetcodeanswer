package leetcode.leetcode16;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1576 {

    char one='a';
    char two='b';
    char three='c';
    public String modifyString(String s) {
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(s.charAt(i)=='?'){
                char pre=i>=1?c[i-1]:'d';
                char post=i<c.length-1?c[i+1]:'d';
                Set<Character> set=new HashSet<>();
                set.add(pre);
                set.add(post);
                if(set.contains(one)&&set.contains(two))
                    c[i]=three;
                else if(set.contains(one))
                    c[i]=two;
                else
                    c[i]=one;
            }
        }
        return new String(c);
    }
}

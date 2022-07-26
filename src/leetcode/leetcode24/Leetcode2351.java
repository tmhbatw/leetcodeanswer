package leetcode.leetcode24;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2351 {

    public char repeatedCharacter(String s) {
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            if(set.contains(c))
                return c;
            set.add(c);
        }

        return 'a';
    }

}

package leetcode.leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode205 {
    /*Description
    * 给定两个字符串s和t，判断它们是否是同构的。
    * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
    * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
    * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
    * */

    public boolean isIsomorphic(String s, String t) {
        if(s==null&&t==null)
            return true;
        if(s==null||t==null)
            return false;
        int sLength=s.length(),tLength=t.length();
        Map<Character,Character> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<sLength;i++){
            char c1=s.charAt(i),c2=t.charAt(i);
            if(!map.containsKey(c1)) {
                if(set.contains(c2))
                    return false;
                map.put(c1, c2);
                set.add(c2);
            }
            if(c2!=map.getOrDefault(c1,' '))
                return false;
        }
        return true;
    }
}

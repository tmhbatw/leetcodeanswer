package leetcode12;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1119 {
    /*Description
    * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
    * */

    public String removeVowels(String s) {
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(!set.contains(cur))
                sb.append(cur);
        }
        return sb.toString();
    }
}

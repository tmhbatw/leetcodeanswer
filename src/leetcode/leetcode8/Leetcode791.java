package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode791 {

    public String customSortString(String order, String s) {
        int[] num=new int[26];
        for(int i=0;i<order.length();i++)
            num[order.charAt(i)-'a']=i;
        List<Character> l=new ArrayList<>();
        for(char c:s.toCharArray())
            l.add(c);
        Collections.sort(l,(o1, o2)->{
            return num[(int)o1-'a']-num[(int)o2-'a'];
        });
        StringBuilder sb=new StringBuilder();
        for(char c:l)
            sb.append(c);
        return sb.toString();
    }
}

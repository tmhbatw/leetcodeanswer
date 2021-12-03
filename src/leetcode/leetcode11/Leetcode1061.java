package leetcode.leetcode11;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1061 {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character,Character> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);

            map.putIfAbsent(c1,c1);
            map.putIfAbsent(c2,c2);

            char t1=getType(c1,map);
            char t2=getType(c2,map);
            if(t2>t1){
                char temp=t1;
                t1=t2;
                t2=temp;
            }
            map.put(t1,t2);
        }

        StringBuilder res=new StringBuilder();
        for(char c:baseStr.toCharArray()){
            map.putIfAbsent(c,c);
            res.append(getType(c,map));
        }
        return res.toString();
    }

    private char getType(char c, Map<Character,Character> map){
        if(map.get(c)==c)
            return c;
        return getType(map.get(c),map);
    }
}

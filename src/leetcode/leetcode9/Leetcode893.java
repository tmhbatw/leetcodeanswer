package leetcode.leetcode9;

import java.util.*;

public class Leetcode893 {
    public int numSpecialEquivGroups(String[] words) {
        Map<String, Set<String>> map=new HashMap<>();
        for(String word:words){
            String type=getType(word);
            map.putIfAbsent(type,new HashSet<>());
            map.get(type).add(word);
        }
        return map.size();
    }

    private String getType(String cur){
        char[] c=cur.toCharArray();
        char[] c1=new char[(c.length+1)/2];
        char[] c2=new char[c.length/2];
        for(int i=0;i<c.length;i+=2){
            c1[i/2]=c[i];
        }
        for(int i=1;i<c.length;i+=2){
            c2[i/2]=c[i];
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        return new String(c1)+" "+new String(c2);
    }
}

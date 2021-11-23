package leetcode.leetcode9;

import java.util.*;

public class Leetcode839 {

    public int numSimilarGroups(String[] strs) {
        Map<String,String> type=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            type.putIfAbsent(strs[i],strs[i]);
            for(int j=i+1;j<strs.length;j++){
                type.putIfAbsent(strs[j],strs[j]);
                if(isSimilar(strs[i],strs[j])){
                    String t1=getType(type,strs[i]);
                    String t2=getType(type,strs[j]);
                    type.put(t2,t1);
                }
            }
        }

        Set<String> set=new HashSet<>();
        for(String str:strs){
            set.add(getType(type,str));
        }
        return set.size();
    }

    private boolean isSimilar(String s1,String s2){
        int diff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
        }
        return diff==2;
    }

    private String getType(Map<String,String> type,String s){
        if(type.get(s).equals(s))
            return s;
        return getType(type,type.get(s));
    }
}

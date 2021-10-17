package leetcode.leetcode20;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1941 {

    public boolean areOccurrencesEqual(String s) {
        int[] num=new int[26];
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
        }
        Set<Integer> set=new HashSet<>();
        for(int cur:num){
            if(cur>0)
                set.add(cur);
        }
        return set.size()==1;
    }
}

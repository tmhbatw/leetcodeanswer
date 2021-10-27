package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(s.length()<p.length())
            return result;
        int[] num=new int[26];
        for(int i=0;i<p.length();i++){
            num[p.charAt(i)-'a']++;
            num[s.charAt(i)-'a']--;
        }
        if(isSame(num))
            result.add(0);
        for(int i=p.length();i<s.length();i++){
            num[s.charAt(i)-'a']--;
            num[s.charAt(i-p.length())-'a']++;
            if(isSame(num))
                result.add(i-p.length()+1);
        }

        return result;
    }

    private boolean isSame(int[] num1){
        for(int i=0;i<26;i++){
            if(num1[i]!=0)
                return false;
        }
        return true;
    }
}

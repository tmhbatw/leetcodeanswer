package leetcode.leetcode23;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2273 {

    public List<String> removeAnagrams(String[] words) {
        List<String> result=new ArrayList<>();
        result.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(isSame(words[i-1],words[i]))
                continue;
            result.add(words[i]);
        }
        return result;
    }

    private boolean isSame(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        int[] num=new int[26];
        for(char cur:s1.toCharArray())
            num[cur-'a']++;
        for(char cur:s2.toCharArray())
            num[cur-'a']--;

        for(int n:num){
            if(n!=0)
                return false;
        }
        return true;
    }
}

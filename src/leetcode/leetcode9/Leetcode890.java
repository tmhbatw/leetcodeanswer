package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.List;

public class Leetcode890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String p=getPattern(pattern);
        List<String> result=new ArrayList<>();
        for(String word:words){
            if(getPattern(word).equals(p))
                result.add(word);
        }
        return result;
    }

    private String getPattern(String cur){
        int[] num=new int[26];
        int index=1;
        for(int i=0;i<cur.length();i++){
            char c=cur.charAt(i);
            if(num[c-'a']!=0)
                continue;
            num[c-'a']=index++;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cur.length();i++){
            int start=i;
            char c=cur.charAt(i);
            while(i<cur.length()-1&&cur.charAt(i+1)==c)
                i++;
            sb.append(num[c-'a']).append(" ").append(i-start).append(" ");
        }
        return sb.toString();
    }
}

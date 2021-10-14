package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode1002 {

    public List<String> commonChars(String[] words) {
        if(words.length==0)
            return Collections.emptyList();
        int[] num=new int[26];
        Arrays.fill(num,Integer.MAX_VALUE);

        for(String cur:words){
            int[] n=getLetterTime(cur);
            for(int i=0;i<26;i++){
                num[i]=Math.min(num[i],n[i]);
            }
        }

        List<String> result=new ArrayList<>();
        for(int i=0;i<26;i++){
            for(int j=0;j<num[i];j++)
                result.add((char)(i+'a')+"");
        }

        return result;
    }

    private int[] getLetterTime(String cur){
        int[] num=new int[26];
        for(int i=0;i<cur.length();i++){
            num[cur.charAt(i)-'a']++;
        }
        return num;
    }
}

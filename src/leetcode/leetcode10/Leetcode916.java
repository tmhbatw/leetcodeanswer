package leetcode.leetcode10;

import java.util.ArrayList;
import java.util.List;

public class Leetcode916 {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result=new ArrayList<>();
        int[] time=new int[26];
        for(String word:words2)
            getMaxTime(word,time);

        for(String word:words1){
            int[] t=getTime(word);
            boolean f=true;
            for(int i=0;i<26;i++){
                if (t[i] < time[i]) {
                    f = false;
                    break;
                }
            }
            if(f)
                result.add(word);
        }
        return result;
    }

    private int[] getTime(String cur){
        int[] t=new int[26];
        for(char c:cur.toCharArray()){
            t[c-'a']++;
        }
        return t;
    }

    private void getMaxTime(String cur,int[] num){
        int[] t=getTime(cur);
        for(int i=0;i<num.length;i++){
            num[i]=Math.max(num[i],t[i]);
        }
    }


}

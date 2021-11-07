package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1255 {

    int result=0;
    int[] score;
    int[] letter=new int[26];

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.score=score;
        for(char c:letters)
            letter[c-'a']++;
        dfs(0,words,0);
        return result;
    }

    private void dfs(int index, String[] words,int sum){
        if(index==words.length)
            return;
        dfs(index+1,words,sum);
        sum+=1<<index;
        int result=getMaxValue(sum,words);
        if(result==-1)
            return;
        this.result=Math.max(this.result,result);
        dfs(index+1,words,sum);
    }

    private int getMaxValue(int sum,String[] words){
        String s=Integer.toBinaryString(sum);
        int[] num=new int[26];
        for(int j=s.length()-1;j>=0;j--){
            if(s.charAt(j)=='1'){
                String cur=words[s.length()-j-1];
                for(char c:cur.toCharArray()){
                    num[c-'a']++;
                }
            }
        }
        int result=0;
        for(int i=0;i<26;i++){
            if(num[i]>letter[i])
                return -1;
            result+=score[i]*num[i];
        }

        return result;
    }
}

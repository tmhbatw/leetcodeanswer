package leetcode4;

public class Leetcode318 {
    /*Description
    * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
    * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
    * */

    public int maxProduct(String[] words) {
        int length=words.length;
        int[] time=new int[length];
        for(int i=0;i<length;i++)
            time[i]=getRes(words[i]);
        int result=0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if((time[i]&time[j])==0)
                    result=Math.max(result,words[i].length()*words[j].length());
            }
        }
        return result;
    }

    private int getRes(String cur){
        boolean[] reached=new boolean[26];
        for(int i=0;i<cur.length();i++)
            reached[cur.charAt(i)-'a']=true;
        int res=0,time=1;
        for(int i=0;i<26;i++){
            if(reached[i])
                res+=time;
            time*=2;
        }
        return res;
    }
}

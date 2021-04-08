package leetcode.leetcode6;

import java.util.ArrayList;
import java.util.List;

public class Leetcode500 {
    /*Description
    * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
    * 美式键盘 中：
    * 第一行由字符 "qwertyuiop" 组成。
    * 第二行由字符 "asdfghjkl" 组成。
    * 第三行由字符 "zxcvbnm" 组成。
    * */

    int[] dp=new int[26];
    public String[] findWords(String[] words) {
        initDp();
        List<String> result=new ArrayList<>();
        for(String cur:words){
            if(isMatch(cur))
                result.add(cur);
        }
        String[] res=new String[result.size()];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        return res;
    }

    private boolean isMatch(String cur){
        if(cur==null||cur.length()==0)
            return true;
        cur=cur.toLowerCase();
        int type=getType(cur.charAt(0));
        for(int i=1;i<cur.length();i++){
            if(type!=getType(cur.charAt(i)))
                return false;
        }
        return true;
    }

    private int getType(char cur){
        return dp[cur-'a'];
    }

    private void initDp(){
        String type1="qwertyuiop";
        for(int i=0;i<type1.length();i++)
            dp[type1.charAt(i)-'a']=1;
        String type2="asdfghjkl";
        for(int i=0;i<type2.length();i++)
            dp[type2.charAt(i)-'a']=2;
        String type3="zxcvbnm";
        for(int i=0;i<type3.length();i++)
            dp[type3.charAt(i)-'a']=3;
    }
}

package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Leetcode784 {

    List<String> result=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        dfs(s.toCharArray(),0);
        return result;
    }

    private void dfs(char[] s,int index){
        if(index==s.length){
            result.add(new String(s));
            return;
        }
        if(s[index]>'9'||s[index]<'0'){
            char[] newS=s.clone();
            newS[index]=getChar(s[index]);
            dfs(newS,index+1);
        }
        dfs(s,index+1);
    }

    private char getChar(char c){
        if(c<='Z'&&c>='A')
            return (char) (c-'A'+'a');
        return (char)(c-'a'+'A');
    }
}

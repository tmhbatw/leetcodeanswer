package leetcode.leetcode18;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1763 {

    public String longestNiceSubstring(String s) {
        int count=0;
        int ss=0;
        for(int i=0;i<s.length();i++) {
            boolean[] num1=new boolean[26];
            boolean[] num2=new boolean[26];
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)>='a'&&s.charAt(j)<='z')
                    num1[s.charAt(j)-'a']=true;
                else
                    num2[s.charAt(j)-'A']=true;
                if(isSame(num1,num2)){
                    if(j-i+1>count){
                        count=j-i+1;
                        ss=i;
                    }
                }
            }
        }
        return s.substring(ss,ss+count);
    }

    private boolean isSame(boolean[] num1,boolean [] num2){
        for(int i=0;i<26;i++){
            if(num1[i]!=num2[i])
                return false;
        }
        return true;
    }
}

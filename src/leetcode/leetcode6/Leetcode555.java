package leetcode.leetcode6;

import java.util.Arrays;

public class Leetcode555 {

    public String splitLoopedString(String[] strs) {
        char maxChar='a';
        for(int i=0;i<strs.length;i++){
            String reverse=new StringBuilder(strs[i]).reverse().toString();
            if(strs[i].compareTo(new StringBuilder(strs[i]).reverse().toString())<0)
                strs[i]=reverse;

            for(int j=0;j<strs[i].length();j++)
                maxChar= (char) Math.max(maxChar,strs[i].charAt(j));
        }

        String res="";

        for(int i=0;i<strs.length;i++){
            StringBuilder other=new StringBuilder();
            for(int j=i+1;j<strs.length;j++)
                other.append(strs[j]);
            for(int j=0;j<i;j++)
                other.append(strs[j]);

            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)==maxChar){
                    String s=strs[i].substring(j)+other+strs[i].substring(0,j);
                    if(res.compareTo(s)<0)
                        res=s;
                    s=new StringBuilder(strs[i].substring(0,j+1)).reverse().toString()+other+
                            new StringBuilder(strs[i].substring(j+1)).reverse().toString();
                    if(res.compareTo(s)<0)
                        res=s;
                }
            }
        }
        return res;
    }
}

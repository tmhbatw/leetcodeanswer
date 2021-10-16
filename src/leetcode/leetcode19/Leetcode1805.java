package leetcode.leetcode19;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1805 {
    public int numDifferentIntegers(String word) {
        Set<String> set=new HashSet<>();
        int length=word.length();
        for(int i=0;i<length;i++){
            char cur=word.charAt(i);
            if(cur<='9'&&cur>='0'){
                StringBuilder sb=new StringBuilder();
                sb.append(cur);
                while(i<word.length()-1&&(word.charAt(i+1)<='9')&&word.charAt(i+1)>='0')
                    sb.append(word.charAt(++i));
                int j=0;
                for(;j<sb.length();j++){
                    if(sb.charAt(j)!='0')
                        break;
                }
                if(j<sb.length())
                    set.add(sb.substring(j));
                else
                    set.add("0");
            }
        }
        return set.size();
    }
}

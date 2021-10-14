package leetcode.leetcode9;

import java.util.HashSet;
import java.util.Set;

public class Leetcode859 {

    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        int index1=-1;
        int index2=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                if(index1==-1){
                    index1=i;
                }else if(index2==-1)
                    index2=i;
                else
                    return false;
            }
        }
        if(index1==-1)
            return hasSameChar(s);
        if(index2==-1)
            return false;
        return s.charAt(index1)==goal.charAt(index2)&&s.charAt(index2)==goal.charAt(index1);
    }

    private boolean hasSameChar(String s){
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
                return true;
            set.add(s.charAt(i));
        }
        return false;
    }
}

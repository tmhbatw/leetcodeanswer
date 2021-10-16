package leetcode.leetcode18;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int index1=-1;
        int index2=-1;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(index1==-1){
                    index1=i;
                    continue;
                }
                if(index2==-1){
                    index2=i;
                    continue;
                }
                return false;
            }
        }
        if(index2==-1){
            return index1==-1;
        }
        return s1.charAt(index1)==s2.charAt(index2)&&s1.charAt(index2)==s2.charAt(index1);
    }

}

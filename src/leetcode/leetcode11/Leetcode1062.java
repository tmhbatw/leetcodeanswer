package leetcode.leetcode11;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1062 {

    public int longestRepeatingSubstring(String s) {
        int l=0,r=s.length()-1;

        while(l<r){
            int mid=(l+r+1)/2;
            if(isMatch(mid,s))
                l=mid;
            else
                r=mid-1;
        }
        return l;
    }

    private boolean isMatch(int mid,String s){
        Set<String> set=new HashSet<>();
        for(int i=0;i<=s.length()-mid;i++){
            String cur=s.substring(i,i+mid);
            if(set.contains(cur))
                return true;
            set.add(cur);
        }
        return false;
    }
}

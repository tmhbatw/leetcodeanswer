package leetcode.leetcode16;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1554 {

    public boolean differByOne(String[] dict) {
        Set<String> set=new HashSet<>();
        for(String d:dict){
            if(getRes(d,set))
                return true;
        }
        return false;
    }

    private boolean getRes(String word,Set<String> set){
        for(int i=0;i<word.length();i++){
            String cur=word.substring(0,i)+" "+word.substring(i+1);
            if(set.contains(cur))
                return true;
            set.add(cur);
        }
        return false;
    }
}

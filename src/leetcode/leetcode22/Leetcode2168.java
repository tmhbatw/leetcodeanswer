package leetcode.leetcode22;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2168 {

    public int equalDigitFrequency(String s) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            int[] time=new int[10];
            for(int j=i;j<s.length();j++){
                int index=s.charAt(j)-'0';
                time[index]++;
                if(match(time,time[index]))
                    set.add(s.substring(i,j+1));
            }
        }
        return set.size();
    }

    private boolean match(int[] time,int cur){
        for(int num:time){
            if(num!=0&&num!=cur)
                return false;
        }
        return true;
    }
}

package leetcode.leetcode25;

import java.util.Arrays;

public class Leetcode2423 {

    public boolean equalFrequency(String word) {
        int[] time=new int[26];
        for(char c:word.toCharArray())
            time[c-'a']++;
        Arrays.sort(time);
        if(time[25]==1)
            return true;
        return removeSmall(time)||removeBig(time);
    }

    private boolean removeSmall(int[] time){
        int i=0;
        for(;i<26;i++){
            if(time[i]==1){
                break;
            }
        }
        if(i>=25)
            return false;
        int cur=time[i+1];
        for(i=i+1;i<26;i++){
            if(time[i]!=cur)
                return false;
        }
        return true;
    }

    private boolean removeBig(int[] time){
        time[25]--;
        int pre=time[25];
        for(int num:time){
            if(num!=pre&&num>0)
                return false;
        }
        return true;
    }
}

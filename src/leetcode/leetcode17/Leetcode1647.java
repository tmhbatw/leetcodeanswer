package leetcode.leetcode17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1647 {

    public int minDeletions(String s) {
        int[] num=new int[26];
        for(char c:s.toCharArray())
            num[c-'a']++;

        Arrays.sort(num);
        int result=0;
        int max=num[25]-1;
        for(int j=24;j>=0;j--){
            if(num[j]==0)
                break;
            if(num[j]>max){
                result+=num[j]-max;
                max=Math.max(max-1,0);
            }else
                max=num[j]-1;
        }
        return result;
    }
}

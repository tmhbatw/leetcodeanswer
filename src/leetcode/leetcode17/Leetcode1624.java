package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] num=new int[26];
        Arrays.fill(num,-1);
        int res=-1;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            int pre;
            if((pre=num[cur-'a'])!=-1){
                res=Math.max(i-pre-1,res);
            }
            else
                num[cur-'a']=i;
        }
        return res;
    }
}

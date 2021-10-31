package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1641 {

    public int countVowelStrings(int n) {
        int[] res=new int[5];
        res[0]=1;

        while(n-->0){
            int[] cur=new int[5];
            for(int j=0;j<5;j++){
                for(int i=0;i<=j;i++){
                    cur[j]+=res[i];
                }
            }
            res=cur;
        }
        return Arrays.stream(res).sum();
    }
}

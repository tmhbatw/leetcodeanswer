package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1806 {

    public int reinitializePermutation(int n) {
        int[] num=new int[n];
        for(int i=0;i<n;i++)
            num[i]=i;

        int result=0;
        while(true){
            result++;

            int[] cur=new int[n];
            for(int i=0;i<n;i++){
                if(i%2==0)
                    cur[i]=num[i/2];
                else
                    cur[i]=num[n / 2 + (i - 1) / 2];
            }

            if(isSame(cur))
                break;
            num=cur;
        }
        return result;
    }

    private boolean isSame(int[] num1){
        for(int i=0;i<num1.length;i++){
            if(num1[i]!=i)
                return false;
        }
        return true;
    }
}

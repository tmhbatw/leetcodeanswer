package leetcode.leetcode25;

import java.util.*;

public class Leetcode2403 {

    public long minimumTime(int[] power) {
        int n=power.length;
        long[] res=new long[1<<(n)];

        for(int i=1;i<res.length;i++){
            res[i]=Long.MAX_VALUE;
            for(int j=0;j<n;j++){
                int bit=Integer.bitCount(i);
                if((i&(1<<j))>0){
                    res[i]=Math.min(res[i],res[i-(1<<j)]+(power[j]-1)/bit+1);
                }
            }
        }
        return res[res.length-1];
    }


}

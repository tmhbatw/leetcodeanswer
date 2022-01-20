package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2141 {

    public long maxRunTime(int n, int[] batteries) {
        long r=0;
        for(int cur:batteries)
            r+=cur;
        long l=1;
        r/=n;


        while(l<r){
            long mid=(l+r+1)/2;

            long sum=0;
            for(int b:batteries){
                sum+=Math.min(b,mid);
            }

            if(sum>=n*mid){
                l=mid;
            }else{
                r=mid-1;
            }
        }

        return l;
    }
}

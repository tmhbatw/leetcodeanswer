package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1891 {

    public int maxLength(int[] ribbons, int k) {
        int l=0,r= Arrays.stream(ribbons).max().getAsInt();

        while(l<r) {
            int mid = (l + r+1) / 2;
            if(isMatch(mid,ribbons,k))
                l=mid;
            else
                r=mid-1;
        }

        return l;
    }

    private boolean isMatch(int mid,int[] ribbons,int k){
        for(int n:ribbons){
            k-=n/mid;
        }
        return k<=0;
    }
}

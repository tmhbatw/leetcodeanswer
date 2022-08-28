package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2187 {

    public long minimumTime(int[] time, int totalTrips) {
        long l=1,r= (long)Arrays.stream(time).min().getAsInt()*totalTrips;
        while(l<r){
            long mid = l+(r-l)/2;
            if(match(time,totalTrips,mid))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    private boolean match(int[] time, int to,long mid){
        long count = 0;
        for(int t:time){
            count += mid/t;
        }
        return count>=to;
    }

}

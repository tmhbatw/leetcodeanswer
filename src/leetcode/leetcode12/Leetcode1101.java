package leetcode.leetcode12;

import java.util.Arrays;

public class Leetcode1101 {

    public int shipWithinDays(int[] weights, int days) {
        int l=1;
        int r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(weights,days,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    private boolean isMatch(int[] weights,int days,int mid){
        int cur=0;
        int count=0;
        for(int num:weights){
            if(num>mid)
                return false;
            if(cur+num>mid){
                count++;
                cur=num;
            }else
                cur+=num;
        }
        return count+1<=days;
    }
}

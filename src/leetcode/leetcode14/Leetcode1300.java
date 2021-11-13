package leetcode.leetcode14;

import java.util.Arrays;

public class Leetcode1300 {

    public int findBestValue(int[] arr, int target) {
        int l=1,r= Arrays.stream(arr).max().getAsInt();
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(isMatch(arr,mid,target)){
                l=mid;
            }
            else
                r=mid-1;
        }

        int val1=getRes(arr,l);
        int val2=getRes(arr,l+1);
        if(target-val1<=Math.abs(val2-target))
            return l;
        return l+1;
    }

    private int getRes(int[] arr,int mid){
        int sum=0;
        for(int num:arr)
            sum+=Math.min(num,mid);
        return sum;
    }


    private boolean isMatch(int[] arr,int mid, int target){
        int sum=0;
        for(int cur:arr){
            sum += Math.min(cur, mid);
        }
        return sum<=target;
    }
}

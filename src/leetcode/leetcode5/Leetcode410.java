package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode410 {

    public int splitArray(int[] nums, int m) {
        int l= Arrays.stream(nums).max().getAsInt(),r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(nums,m,mid)){
                r=mid;
            }else
                l=mid+1;
        }
        return l;
    }

    private boolean isMatch(int[] nums,int m,int mid){
        int count=0;
        int preSum=0;
        for(int num:nums){
            if(preSum+num>mid){
                preSum=num;
                count++;
            }else
                preSum+=num;
        }
        return count+1<=m;
    }
}

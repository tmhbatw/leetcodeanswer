package leetcode.leetcode20;

import java.util.Arrays;

public class Leetcode1918 {

    //第k小的子数组
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int l=1,r= Arrays.stream(nums).sum();


        while(l<r){
            int mid=l+(r-l+1)/2;
            if(isMatch(nums,mid,k))
                l=mid;
            else
                r=mid-1;
        }
        return l;
    }

    private boolean isMatch(int[] nums,int mid,int k){
        int sum=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            while(sum>=mid){
                sum-=nums[i++];
            }
            k-=(j-i+1);
        }
        return k>0;
    }
}

package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1838 {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long[] sum=new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=nums[i]+sum[i];
        }

        int result=0;
        for(int i=0;i<nums.length;i++){
            while(i<nums.length-1&&nums[i]==nums[i+1])
                i++;
            result=Math.max(getRes(sum,i,k,nums[i]),result);
        }

        return result;
    }

    private int getRes(long[] sum,int i,int k,int num){
        int l=0,r=i;
        while(l<r){
            int mid=(l+r)/2;
            long s=sum[i+1]-sum[mid];
            long t=i-mid+1;
            if(t*num-s<=k){
                r=mid;
            }else{
                l=mid+1;
            }
        }

        return i-l+1;
    }

}

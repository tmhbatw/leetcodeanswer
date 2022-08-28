package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1498 {

    int mod=1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int result =0;
        int[] add=getAdd(nums.length);
        for(int i=0;i<nums.length;i++){
            if(nums[i]*2>target)
                break;
            int l=i,r=nums.length-1;
            while(l<r){
                int mid=(l+r+1)/2;
                if(nums[mid]+nums[i]<=target)
                    l=mid;
                else
                    r=mid-1;
            }
            result += add[l-i];
            result%=mod;
        }
        return result;
    }

    private int[] getAdd(int n){
        int[] time=new int[n];
        time[0]=1;
        for(int i=1;i<n;i++)
            time[i]=time[i-1]*2%mod;
        return time;
    }
}

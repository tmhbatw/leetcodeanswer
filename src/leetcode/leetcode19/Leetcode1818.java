package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1818 {

    int mod=1000000007;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int res=0;
        for(int i=0;i<nums1.length;i++){
            res=(res+Math.abs(nums1[i]-nums2[i]))%mod;
        }

        int diff=0;
        int[] num=nums1.clone();
        Arrays.sort(num);

        for(int i=0;i<nums1.length;i++){
            int curVal;

            if(num[0]>=nums2[i]) {
                curVal = num[0] - nums2[i];
            }
            else{
                int l=0,r=num.length-1;
                while(l<r){
                    int mid=(l+r)/2;
                    if(num[mid]>=nums2[i])
                        r=mid;
                    else
                        l=mid+1;
                }

                if(num[l]<nums2[i])
                    curVal=nums2[i]-num[l];
                else
                    curVal=Math.min(nums2[i]-num[l-1],num[l]-nums2[i]);
            }
            diff=Math.max(diff,Math.abs(nums1[i]-nums2[i])-curVal);

        }
        diff%=mod;
        return res<diff?res+mod-diff:res-diff;
    }
}

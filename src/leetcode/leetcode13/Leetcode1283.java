package leetcode.leetcode13;

public class Leetcode1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int l=1,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(match(nums,threshold,mid)){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return l;
    }

    private boolean match(int[] nums,int threshold,int mid){
        long result = 0;
        for(int num:nums){
            result += (num-1)/mid+1;
        }
        return result<=threshold;
    }
}

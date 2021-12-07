package leetcode.leetcode11;

public class Leetcode1060 {

    public int missingElement(int[] nums, int k) {
        int l=nums[0];
        int r=Integer.MAX_VALUE;

        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(nums,k,mid))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    private boolean isMatch(int[] nums,int k,int mid){
        if(mid>nums[nums.length-1]){
            return mid-nums[0]-nums.length+1>=k;
        }

        int l=0,r=nums.length-1;
        while(l<r){
            int m=(l+r+1)/2;
            if(nums[m]<=mid)
                l=m;
            else
                r=m-1;
        }
        int count=mid-nums[0]-l;
        return count>=k;
    }
}

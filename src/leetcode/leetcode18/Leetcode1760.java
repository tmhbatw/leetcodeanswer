package leetcode.leetcode18;

public class Leetcode1760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int l=1,r=1000000000;
        while(l<r){
            int mid=(l+r)/2;
            if(isMatch(nums,mid,maxOperations))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }

    private boolean isMatch(int[] nums,int mid,int max){
        for(int num:nums){
            max-=(num-1)/mid;
        }
        return max>=0;
    }
}

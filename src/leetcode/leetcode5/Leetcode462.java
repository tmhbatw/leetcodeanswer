package leetcode.leetcode5;

public class Leetcode462 {

    public int minMoves2(int[] nums) {
        //找到中位数
        int k=(nums.length-1)/2;
        int mid=getRes(nums,k,0,nums.length-1);
        int result=0;
        for(int cur:nums)
            result+=Math.abs(cur-mid);
        return result;
    }

    private int getRes(int[] nums, int k,int start,int end){
        if(start==end&&start==k)
            return nums[start];
        int cur=nums[start];
        int l=start+1,r=end;
        while(l<r){
            if(nums[l]<=cur){
                l++;
                continue;
            }
            if(nums[r]>cur){
                r--;
                continue;
            }
            int temp=nums[l];
            nums[l++]=nums[r];
            nums[r--]=temp;
        }
        if(nums[l]>cur)
            l--;
        nums[start]=nums[l];
        nums[l]=cur;
        if(l==k)
            return cur;
        if(k>l)
            return getRes(nums,k,l+1,end);
        return getRes(nums,k,start,l-1);
    }
}

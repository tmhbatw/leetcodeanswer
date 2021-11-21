package leetcode.leetcode7;

public class Leetcode698 {
    /*Description
    * 给定一个整数数组  nums 和一个正整数 k，找出是否有
    * 可能把这个数组分成 k 个非空子集，其总和都相等。
     * */

    boolean result=false;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int cur:nums)
            sum+=cur;
        if(sum%k!=0)
            return false;
        sum/=k;
        dfs(nums,0,new int[k],sum);
        return result;
    }

    private void dfs(int[] nums,int index,int[] sum,int target){
        if(result)
            return;
        if(index==nums.length) {
            result = true;
            return;
        }

        for(int i=0;i<sum.length;i++){
            if(sum[i]+nums[index]<=target){
                sum[i]+=nums[index];
                dfs(nums,index+1,sum,target);
                sum[i]-=nums[index];
            }
        }
    }
}

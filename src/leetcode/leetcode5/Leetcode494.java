package leetcode.leetcode5;

public class Leetcode494 {

    int result=0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,0,target,0);
        return result;
    }

    private void dfs(int[] nums,int index,int target,int cur){
        if(index==nums.length) {
            result+=cur==target?1:0;
            return;
        }
        dfs(nums,index+1,target,cur+nums[index]);
        dfs(nums,index+1,target,cur-nums[index]);
    }
}

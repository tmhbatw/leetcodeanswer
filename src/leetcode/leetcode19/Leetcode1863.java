package leetcode.leetcode19;

public class Leetcode1863{

    int result=0;
    public int subsetXORSum(int[] nums) {
        dfs(nums,0,0);
        return result;
    }

    private void dfs(int[] nums,int index,int cur){

        if(index==nums.length)
            return;
        dfs(nums,index+1,cur);
        dfs(nums,index+1,cur^nums[index]);
        result+=cur^nums[index];

    }
}

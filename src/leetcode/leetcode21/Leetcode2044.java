package leetcode.leetcode21;

public class Leetcode2044 {

    int max=0;
    int result=0;
    public int countMaxOrSubsets(int[] nums) {
        dfs(nums,0,0);
        return result;
    }

    private void dfs(int[] nums,int index, int cur){

        if(index==nums.length){
            if(cur>max){
                max=cur;
                result=0;
            }
            if(cur==max)
                result++;
            return;
        }
        dfs(nums,index+1,cur);
        dfs(nums,index+1,cur|nums[index]);
    }
}

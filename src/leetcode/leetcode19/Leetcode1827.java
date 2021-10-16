package leetcode.leetcode19;

public class Leetcode1827 {
    public int minOperations(int[] nums) {
        int result=0;
        int pre=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<pre+1){
                result+=pre+1-nums[i];
            }else
                pre=nums[i];
        }
        return result;
    }
}

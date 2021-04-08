package leetcode.leetcode1;

public class Leetcode55 {
    /*Description
    *给定一个非负整数数组，你最初位于数组的第一个位置。
    * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
    * 判断你是否能够到达最后一个位置。
    * */

    public boolean canJump(int[] nums) {
        int length=nums.length;
        int index=1;
        for(int i=0;i<index;i++){
            int cur=i+nums[i]+1;
            if(cur>=length)
                return true;
            index=Math.max(cur,index);
        }
        return false;
    }
}

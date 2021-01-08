package leetcode3;

public class Leetcode213 {
    /*Description
    * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
    * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
    * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
    * */

    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int length=nums.length;
        if(length==1)
            return nums[0];
        int[] dp1=new int[length+1];
        int[] dp2=new int[length+1];
        dp1[1]=nums[0];
        for(int i=1;i<length;i++){
            dp1[i+1]=Math.max(dp1[i-1]+nums[i],dp1[i]);
            dp2[i+1]=Math.max(dp2[i-1]+nums[i],dp2[i]);
        }
        return Math.max(dp2[length],dp1[length-1]);
    }
}

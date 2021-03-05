package interview;

public class Problem17_16 {
    /*Description
    * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
    * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
    * */

    public int massage(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] dp=new int[nums.length+1];
        dp[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i+1]=Math.max(dp[i],dp[i-1]+nums[i]);
        }
        return dp[nums.length];
    }
}

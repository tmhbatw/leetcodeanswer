package leetcode.leetcode2;

public class Leetcode152 {
    /*Description
    * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
    * 并返回该子数组所对应的乘积。
    * */

    //保存两个数组，分别存储包含这一位的乘积的最大值和最小值
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int length=nums.length;
        //max和min分别用来保存包含这一位子数组乘积的最大值以及最小值
        int[] max=new int[length+1],min=new int[length+1];
        max[0]=min[0]=1;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            if(nums[i]==0)
                max[i+1]=min[i+1]=0;
            else if(nums[i]>0){
                max[i+1]=Math.max(max[i],1)*nums[i];
                min[i+1]=(min[i]==0?1:min[i])*nums[i];
            }else{
                max[i+1]=(min[i]==0?1:min[i])*nums[i];
                min[i+1]=Math.max(max[i],1)*nums[i];
            }
            result=Math.max(result,max[i+1]);
        }
        return result;
    }
}

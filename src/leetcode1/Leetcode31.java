package leetcode1;

import java.util.Arrays;

public class Leetcode31 {
    /*Description
    *实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    * 必须 原地 修改，只允许使用额外常数空间。
    * */

    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1)
            return;
        int length=nums.length;
        int max=Integer.MIN_VALUE;
        for(int j=length-1;j>=0;j--){
            int cur=nums[j];
            if(max>cur){
                int swapIndex=-1;
                int swapValue=max;
                for(int index=length-1;index>j;index--){
                    if(nums[index]>cur&&nums[index]<=swapValue){
                        swapValue=nums[index];
                        swapIndex=index;
                    }
                }
                nums[j]=swapValue;
                nums[swapIndex]=cur;
                Arrays.sort(nums,j+1,length);
                return;
            }
            max=Math.max(cur,max);
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args){
        int[] num=new int[]{5,4,3,2,1};
        Arrays.sort(num,1,num.length);
        System.out.println(Arrays.toString(num));
    }
}

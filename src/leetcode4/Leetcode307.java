package leetcode4;

import java.util.Arrays;

public class Leetcode307 {
    /*Description
    * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
    * 实现 NumArray 类：
    * NumArray(int[] nums) 用整数数组 nums 初始化对象
    * void update(int index, int val) 将 nums[index] 的值更新为 val
    * int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和
    * （即，nums[left] + nums[left + 1], ..., nums[right]）
    * */

    class NumArray {
        int[] num;
        int[] dp;
        int n;
        public NumArray(int[] nums) {
            this.num=nums;
            n= (int) Math.sqrt(nums.length);
            dp=new int[nums.length/n+1];
            int index=-1;
            for(int i=0;i<nums.length;i++){
                if(i%n==0)
                    index++;
                dp[index]+=nums[i];
            }
            System.out.println(Arrays.toString(num));
            System.out.println(Arrays.toString(dp));
        }

        public void update(int index, int val) {
            dp[index/n]+=val-num[index];
            num[index]=val;
        }

        public int sumRange(int left, int right) {
            int leftIndex=left/n,rightIndex=right/n;
            int result=0;
            if(leftIndex==rightIndex){
                for(int i=left;i<=right;i++)
                    result+=num[i];
                return result;
            }
            for(int i=leftIndex+1;i<=rightIndex-1;i++)
                result+=dp[i];
            for(int i=left;i<leftIndex*n+n;i++)
                result+=num[i];
            for(int i=rightIndex*n;i<=right;i++)
                result+=num[i];
            return result;
        }
    }
}

package leetcode.leetcode1;

import java.util.Arrays;

public class Leetcode16 {
    /*Description
    * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。
    * 返回这三个数的和。假定每组输入只存在唯一答案。
    * */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=100000;
        int diff=100000;
        int length=nums.length;
        for(int i=0;i<nums.length-2;i++){
            int cur=nums[i];
            int left=i+1,right=length-1;
            while(left<right){
                int sum=cur+nums[left]+nums[right];
                if(sum>=target){
                    if(sum-target<diff){
                        diff=sum-target;
                        result=sum;
                    }
                    right--;
                }else{
                    if(target-sum<diff){
                        diff=target-sum;
                        result=sum;
                    }

                    left++;
                }
            }
        }
        return result;
    }
}

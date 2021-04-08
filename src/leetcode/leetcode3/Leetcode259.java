package leetcode.leetcode3;

import java.util.Arrays;

public class Leetcode259 {
    /*Description
    * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件
    * nums[i] + nums[j] + nums[k] < target成立的三元组 i, j, k个数（0 <= i < j < k < n）。
    * */

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            int curTarget=target-nums[i];
            int left=i+1,right=length-1;
            while(left<right){
                if(nums[left]+nums[right]<curTarget){
                    result+=right-left;
                    left++;
                }else
                    right--;
            }
        }
        return result;
    }
}

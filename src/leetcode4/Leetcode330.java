package leetcode4;

import java.util.Arrays;

public class Leetcode330 {
    /*Description
    * 给定一个已排序的正整数数组 nums，和一个正整数n 。从[1, n]
    * 区间内选取任意个数字补充到nums中，使得[1, n]区间内的任何数字都可以用nums中某几个数字的和来表示。
    * 请输出满足上述要求的最少需要补充的数字个数。
    * */

    public int minPatches(int[] nums, int n) {
        int result=0;
        long x=1;

        int length=nums.length;
        int index=0;
        while(x<=n){
            if(index<length&&nums[index]<=x)
                x+=nums[index++];
            else{
                x*=2;
                result++;
            }
        }
        return result;
    }
}

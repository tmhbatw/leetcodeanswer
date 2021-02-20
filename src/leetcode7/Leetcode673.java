package leetcode7;

import java.util.Arrays;

public class Leetcode673 {
    /*Description
    * 给定一个未排序的整数数组，找到最长递增子序列的个数。
    * */
    public int findNumberOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int length=nums.length;
        int[] dp1=new int[length];
        int[] dp2=new int[length];
        int max=0;
        int result=0;
        for(int i=0;i<length;i++){
            dp2[i]++;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp1[i]<dp1[j]){
                        dp1[i]=dp1[j];
                        dp2[i]=dp2[j];
                    }else if(dp1[i]==dp1[j])
                        dp2[i]+=dp2[j];
                }
            }
            dp1[i]++;
            if(dp1[i]>max){
                max=dp1[i];
                result=dp2[i];
            }
            else if(dp1[i]==max)
                result+=dp2[i];
        }
        return result;
    }
}

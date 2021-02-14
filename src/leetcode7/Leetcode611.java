package leetcode7;

import java.util.Arrays;

public class Leetcode611 {
    /*Description
    * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
    * */

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        int result=0;
        for(int i=0;i<length-2;i++){
            if(nums[i]==0)
                continue;
            int k=i+2;
            for(int j=i+1;j<length-1;j++){
                while(k<length&&nums[i]+nums[j]>nums[k])
                    k++;
                result+=k-j-1;
            }
        }
        return result;
    }
}

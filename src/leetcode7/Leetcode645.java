package leetcode7;

import java.util.Arrays;

public class Leetcode645 {
    /*Description
    * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
    * 导致集合 丢失了一个数字 并且 有一个数字重复 。给定一个数组 nums 代表了集合 S 发生错误后的结果。
    * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
    * */

    public int[] findErrorNums(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            while(nums[cur-1]!=cur){
                int temp=nums[cur-1];
                nums[cur-1]=cur;
                cur=temp;
                nums[i]=cur;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return new int[]{nums[i],i+1};
        }
        return null;
    }
}

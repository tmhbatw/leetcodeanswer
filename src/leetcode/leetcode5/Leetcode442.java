package leetcode.leetcode5;

import java.util.*;

public class Leetcode442 {
    /*Description
    * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
    * 找到所有出现两次的元素。
    * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
    * */

    public List<Integer> findDuplicates(int[] nums) {
        if(nums==null)
            return Collections.EMPTY_LIST;
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i+1){
                if(nums[nums[i]-1]==nums[i])
                    break;
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                result.add(nums[i]);
        }
        return result;
    }
}

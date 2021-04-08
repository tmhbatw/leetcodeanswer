package leetcode.leetcode1;

import java.util.*;

public class Leetcode15 {
    /*Description
    *给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
    * 注意：答案中不可以包含重复的三元组。
    * */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int val1=-nums[i];
            int left=i+1,right=length-1;
            while(left<right){
                if(nums[left]+nums[right]<val1)
                    left++;
                else if(nums[left]+nums[right]>val1)
                    right--;
                else {
                        List<Integer> cur = new ArrayList<>();
                        cur.add(-val1);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        result.add(cur);
                    while(left<length-1&&nums[left+1]==nums[left])
                        left++;
                    while(right>1&&nums[right-1]==nums[right])
                        right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}

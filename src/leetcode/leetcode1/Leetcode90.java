package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    /*Description
    * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    * 说明：解集不能包含重复的子集。
    * */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        recursion(result,new ArrayList<>(),0,nums);
        return result;
    }

    private void recursion(List<List<Integer>> list,List<Integer> res,int start,int[] nums){
        list.add(res);
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1])
                continue;
            List<Integer> curRes=new ArrayList<>(res);
            curRes.add(nums[i]);
            recursion(list,curRes,i+1,nums);
        }
    }
}

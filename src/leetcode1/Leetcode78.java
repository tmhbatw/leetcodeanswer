package leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode78 {
    /*Description
    * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
     * */

    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0)
            return Collections.emptyList();
        List<List<Integer>> result=new ArrayList<>();
        recursion(result,new ArrayList<>(),0,nums);
        return result;
    }

    private void recursion(List<List<Integer>> list,List<Integer> res,int start,int[] nums){
        list.add(res);
        for(int i=start;i<nums.length;i++){
            List<Integer> curRes=new ArrayList<>(res);
            curRes.add(nums[i]);
            recursion(list,curRes,i+1,nums);
        }
    }
}

package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47 {
    /*Description
    * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    * */

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        recursion(result,new ArrayList<>(),new boolean[nums.length],0,nums);
        return result;
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,boolean[] reached,int index,int[] nums){
        if(index==nums.length){
            result.add(res);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!reached[i]){
                List<Integer> cur=new ArrayList<>(res);
                cur.add(nums[i]);
                boolean[] curReached=reached.clone();
                curReached[i]=true;
                while(i<nums.length-1&&nums[i+1]==nums[i])
                    i++;
                recursion(result,cur,curReached,index+1,nums);
            }
        }
    }
}

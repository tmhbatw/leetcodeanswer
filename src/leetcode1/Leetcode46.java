package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {
    /*Description
    *给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int length=nums.length;
        recursion(result,new ArrayList<>(),new boolean[length],nums,0,length);
        return result;
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,boolean[] reached,int[] nums,int index,int length){
        if(index==length){
            result.add(res);
            return;
        }
        for(int i=0;i<length;i++){
            if(!reached[i]){
                List<Integer> cur=new ArrayList<>(res);
                boolean[] curReached=reached.clone();
                curReached[i]=true;
                cur.add(nums[i]);
                recursion(result,cur,curReached,nums,index+1,length);
            }
        }
    }
}

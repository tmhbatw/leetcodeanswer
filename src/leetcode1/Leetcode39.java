package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {
    /*Description
    * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所
    * 有可以使数字和为target的组合。candidates中的数字可以无限制重复被选取。
    * 说明：
    * 所有数字（包括target）都是正整数。
    * 解集不能包含重复的组合。
    * */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        recursion(result,new ArrayList<>(),0,target,candidates);
        return result;
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int index,int left,int[] candidates){
        for(int i=index;i<candidates.length;i++){
            if(left>candidates[i])
                return;
            if(left==candidates[i]){
                List<Integer> curRes=new ArrayList<>(res);
                curRes.add(candidates[i]);
                result.add(curRes);
                return;
            }
            List<Integer> curRes=new ArrayList<>(res);
            curRes.add(candidates[i]);
            recursion(result,curRes,i,left-candidates[i],candidates);
        }
    }
}

package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    /*Description
    *给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
    * candidates中的每个数字在每个组合中只能使用一次。
    * 说明：
    * 所有数字（包括目标数）都是正整数
    * 解集不能包含重复的组合。
    * */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        recursion(result,new ArrayList<>(),0,target,candidates);
        return result;
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int index,int left,int[] candidates){
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]>left)
                return;
            if(candidates[i]==left){
                List<Integer> curRes=new ArrayList<>(res);
                curRes.add(candidates[i]);
                result.add(curRes);
                return;
            }
            List<Integer> curRes=new ArrayList<>(res);
            curRes.add(candidates[i]);
            recursion(result,curRes,i+1,left-candidates[i],candidates);
            while(i<candidates.length-1&&candidates[i]==candidates[i+1])
                i++;
        }
    }
}

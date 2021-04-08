package leetcode.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    /*Description
    * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
    * 说明：
    * 所有数字都是正整数。
    * 解集不能包含重复的组合。
    * */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        recursion(1,n,k,new ArrayList<>(),result);
        return result;
    }

    private void recursion(int start,int k,int n,List<Integer> list,List<List<Integer>> result){
        if(k==0&&n==0){
            result.add(list);
            return;
        }
        if(n==0)
            return;
        for(int i=start;i<=9;i++){
            if(k<i)
                break;
            List<Integer> curList=new ArrayList<>(list);
            curList.add(i);
            recursion(i+1,k-i,n-1,curList,result);
        }
    }
}

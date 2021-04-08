package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode77 {
    /*Description
    * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    * */

    public List<List<Integer>> combine(int n, int k) {
        if(n<k)
            return Collections.emptyList();
        List<List<Integer>> list=new ArrayList<>();
        recursion(list,new ArrayList<>(),1,k,n);
        return list;
    }

    private void recursion(List<List<Integer>> list,List<Integer> res,int start,int k,int n){
        if(k==0){
            list.add(res);
            return;
        }
        for(int i=start;i<=n-k+1;i++){
            List<Integer> curRes=new ArrayList<>(res);
            curRes.add(i);
            recursion(list,curRes,i+1,k-1,n);
        }
    }
}

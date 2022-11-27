package leetcode.leetcode25;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2476 {


    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        getList(root,list);
        for(int cur:queries){
            result.add(getList(list,cur));
        }
        return result;
    }

    private List<Integer> getList(List<Integer> list,int cur){
        List<Integer> result=new ArrayList<>();
        if(cur<list.get(0)){
            result.add(-1);
            result.add(list.get(0));
            return result;
        }

        int l=0,r=list.size()-1;
        while(l<r){
            int mid=(l+r+1)/2;
            if(list.get(mid)<=cur){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        result.add(list.get(l));
        if(list.get(l)>=cur){
            result.add(list.get(l));
        }else{
            result.add(l==list.size()-1?-1:list.get(l+1));
        }

        return result;
    }

    public void getList(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        getList(root.left,list);
        list.add(root.val);
        getList(root.right,list);
    }
    private int getMin(TreeNode root,int cur,int result){
        if(root==null)
            return result;
        if(root.val<=cur){
            return getMin(root.right,cur,root.val);
        }
        return getMin(root.left,cur,result);
    }

    private int getMax(TreeNode root,int cur,int result){
        if(root==null)
            return result;
        if(root.val>=cur){
            return getMax(root.left,cur,root.val);
        }
        return getMax(root.right,cur,result);
    }

}

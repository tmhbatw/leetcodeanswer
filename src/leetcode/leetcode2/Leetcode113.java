package leetcode.leetcode2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode113 {
    /*Description
    * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
    * */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return Collections.emptyList();
        pathSum(root,sum,0,new ArrayList<>(),result);
        return result;
    }

    private void pathSum(TreeNode root,int sum,int curSum,List<Integer> list,List<List<Integer>> result){
        curSum+=root.val;
        List<Integer> curList=new ArrayList<>(list);
        curList.add(root.val);
        if(root.left==null&&root.right==null&&curSum==sum){
            result.add(curList);
        }
        if(root.left!=null)
            pathSum(root.left,sum,curSum,curList,result);
        if(root.right!=null)
            pathSum(root.right,sum,curSum,curList,result);
    }
}

package leetcode3;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    /*Description
    * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
    * 说明: 叶子节点是指没有子节点的节点。
    * */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        if(root==null)
            return list;
        recursion(root,list,new StringBuilder());
        return list;
    }

    private void recursion(TreeNode cur,List<String> res,StringBuilder sb){
        StringBuilder curSb=new StringBuilder(sb);
        curSb.append("->").append(cur.val);
        if(cur.left==null&&cur.right==null){
            res.add(curSb.substring(2));
            return;
        }
        if(cur.left!=null)
            recursion(cur.left,res,curSb);
        if(cur.right!=null)
            recursion(cur.right,res,curSb);
    }
}

package leetcode.leetcode1;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode94 {
    /*Description
    * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
    * */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        recursion(result,root);
        return result;
    }

    private void recursion(List<Integer> result,TreeNode root){
        if(root!=null){
            recursion(result,root.left);
            result.add(root.val);
            recursion(result,root.right);
        }
    }
}

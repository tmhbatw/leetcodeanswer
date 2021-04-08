package leetcode.leetcode8;

import datastructure.TreeNode;

public class Leetcode783 {
    /*Description
    * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
    * */

    TreeNode pre=null;
    int result=Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode cur){
        if(cur==null)
            return;
        inorder(cur.left);
        if(pre!=null){
            result=Math.min(result,cur.val-pre.val);
        }
        pre=cur;
        inorder(cur.right);
    }
}

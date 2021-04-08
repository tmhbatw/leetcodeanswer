package leetcode.leetcode5;

import datastructure.TreeNode;

public class Leetcode404 {
    /*Description
    * 计算给定二叉树的所有左叶子之和。
     * */

    int result=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        sumOfLeftLeaves(root,false);
        return result;
    }

    private void sumOfLeftLeaves(TreeNode root,boolean isLeft){
        if(root.left==null&&root.right==null&&isLeft)
            result+=root.val;
        if(root.left!=null)
            sumOfLeftLeaves(root.left,true);
        if(root.right!=null)
            sumOfLeftLeaves(root.right,false);
    }
}

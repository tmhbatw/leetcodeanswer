package leetcode2;

import datastructure.TreeNode;

public class Leetcode101 {
    /*Description
    * 给定一个二叉树，检查它是否是镜像对称的。
     * */

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return recursion(root.left,root.right);
    }

    private boolean recursion(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null)
            return false;
        if(left.val==right.val){
            return recursion(left.left,right.right)&&recursion(left.right,right.left);
        }
        return false;
    }
}

package leetcode.leetcode2;

import datastructure.TreeNode;

public class Leetcode112 {
    /*Description
    * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    * 说明: 叶子节点是指没有子节点的节点。
    * */

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return sum==0;
        return hasPathSum(root,sum,0);
    }

    private boolean hasPathSum(TreeNode root,int sum,int curSum){
        curSum+=root.val;
        if(root.left==null&&root.right==null){
            return curSum==sum;
        }
        if(root.left!=null&&hasPathSum(root.left,sum,curSum)||
                root.right!=null&&hasPathSum(root.right,sum,curSum))
            return true;
        return false;
    }
}

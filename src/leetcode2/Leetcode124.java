package leetcode2;

import datastructure.TreeNode;

public class Leetcode124 {
    /*Description
    * 给定一个非空二叉树，返回其最大路径和。
    * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，
    * 达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
    * */
    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return result;
        getMaxValue(root);
        return result;
    }

    private int getMaxValue(TreeNode root){
        if(root==null)
            return 0;
        int leftValue=getMaxValue(root.left),rightValue=getMaxValue(root.right);
        result=Math.max(rightValue+leftValue+root.val,result);
        return Math.max(Math.max(leftValue,rightValue)+root.val,0);
    }
}

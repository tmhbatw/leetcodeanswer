package leetcode.leetcode6;

import datastructure.TreeNode;

public class Leetcode563 {
    /*Description
    * 给定一个二叉树，计算 整个树 的坡度 。
    * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
    * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
    * 整个树 的坡度就是其所有节点的坡度之和。
    * */

    int result=0;
    public int findTilt(TreeNode root) {
        if(root==null)
            return result;
        getSum(root);
        return result;
    }

    private int getSum(TreeNode node){
        if(node==null)
            return 0;
        int leftNumber=getSum(node.left);
        int rightNumber=getSum(node.right);
        result+=Math.abs(leftNumber-rightNumber);
        return leftNumber+rightNumber+node.val;
    }
}

package leetcode2;

import datastructure.TreeNode;

public class Leetcode129 {
    /*Description
    * 给定一个二叉树，它的每个结点都存放一个0-9的数字，每条从根到叶子节点的路径都代表一个数字。
    * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
    * 计算从根到叶子节点生成的所有数字之和。
    * 说明: 叶子节点是指没有子节点的节点。
    * */
    int result=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return result;
        recursion(root,0);
        return result;
    }

    private void recursion(TreeNode root,int curSum){
        curSum=curSum*10+root.val;
        if(root.left==null&&root.right==null) {
            result+=curSum;
            return ;
        }
        if(root.left!=null)
            recursion(root.left,curSum);
        if(root.right!=null)
            recursion(root.right,curSum);
    }
}

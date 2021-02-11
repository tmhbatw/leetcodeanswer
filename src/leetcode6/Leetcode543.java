package leetcode6;

import datastructure.TreeNode;

public class Leetcode543 {
    /*Description
    * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两
    * 个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
    * */
    int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return result;
    }

    private int recursion(TreeNode root){
        if(root==null)
            return 0;
        int leftNumber=recursion(root.left);
        int rightNumber=recursion(root.right);
        result=Math.max(result,leftNumber+rightNumber);
        return Math.max(leftNumber,rightNumber)+1;
    }
}

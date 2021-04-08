package leetcode.leetcode2;

import datastructure.TreeNode;

public class Leetcode110 {
    /*Description
    * 给定一个二叉树，判断它是否是高度平衡的二叉树。
    * 本题中，一棵高度平衡二叉树定义为：
    * */
    boolean result=true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return result;
    }

    private int getHeight(TreeNode node){
        if(!result)
            return 0;
        if(node==null)
            return 0;
        int leftHeight=getHeight(node.left);
        int rightHeight=getHeight(node.right);
        if(Math.abs(leftHeight-rightHeight)>=2){
            result=false;
            return 0;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}

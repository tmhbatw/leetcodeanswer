package leetcode.leetcode3;

import datastructure.TreeNode;

public class Leetcode235 {
    /*Description
    * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pValue=p.val,qValue=q.val;
        int max=Math.max(pValue,qValue),min=Math.min(pValue,qValue);
        return lowestCommonAncestor(root,max,min);
    }

    private TreeNode lowestCommonAncestor(TreeNode root,int max,int min){
        if(root.val<=max&&root.val>=min)
            return root;
        if(root.val>max)
            return lowestCommonAncestor(root.left,max,min);
        return lowestCommonAncestor(root.right,max,min);
    }
}

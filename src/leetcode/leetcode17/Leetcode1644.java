package leetcode.leetcode17;

import datastructure.TreeNode;

public class Leetcode1644 {

    boolean exist1=false;
    boolean exist2=false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        if(!exist1||!exist2)
            return null;
        return getRes(root,p,q);
    }

    private TreeNode getRes(TreeNode root,TreeNode p,TreeNode q){
        if(root==p||root==q||root==null)
            return root;
        TreeNode left=getRes(root.left,p,q);
        TreeNode right=getRes(root.right,p,q);
        if(left==null)
            return right;
        if(right==null)
            return left;
        return root;
    }

    private void dfs(TreeNode root, TreeNode p,TreeNode q){
        if(root==null||exist1&&exist2)
            return;
        if(root.val==p.val){
            exist1=true;
        }
        if(root.val==q.val){
            exist2=true;
        }
        dfs(root.left,p,q);
        dfs(root.right,p,q);
    }
}

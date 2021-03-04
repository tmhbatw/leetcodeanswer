package interview;

import datastructure.TreeNode;

public class Problem4_8 {
    /*Description
    * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
    * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
    * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null)
            return right;
        if(right==null)
            return left;
        return root;
    }
}

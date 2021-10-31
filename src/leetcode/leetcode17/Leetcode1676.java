package leetcode.leetcode17;

import datastructure.TreeNode;

public class Leetcode1676 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(root==null)
            return null;
        for(TreeNode cur:nodes){
            if(root==cur)
                return root;
        }
        TreeNode l=lowestCommonAncestor(root.left,nodes);
        TreeNode r=lowestCommonAncestor(root.right,nodes);
        if(l==null)
            return r;
        if(r==null)
            return l;
        return root;
    }

}

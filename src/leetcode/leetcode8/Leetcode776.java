package leetcode.leetcode8;

import datastructure.TreeNode;

public class Leetcode776 {


    //第一个树的节点值应该是严格小的，第二颗树的节点值应该是严格大的
    public TreeNode[] splitBST(TreeNode root, int target) {
        if(root==null)
            return new TreeNode[2];

        if(root.val>target){
            TreeNode[] l=splitBST(root.left,target);
            root.left=l[1];
            return new TreeNode[]{l[0],root};
        }

        TreeNode[] r=splitBST(root.right,target);
        root.right=r[0];
        return new TreeNode[]{root,r[1]};
    }
}

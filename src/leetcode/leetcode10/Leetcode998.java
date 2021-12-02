package leetcode.leetcode10;

import datastructure.TreeNode;

public class Leetcode998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null||root.val<val){
            TreeNode res=new TreeNode(val);
            res.left=root;
            return res;
        }
        root.right=insertIntoMaxTree(root.right,val);
        return root;
    }
}

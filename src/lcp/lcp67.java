package lcp;

import datastructure.TreeNode;

public class lcp67 {

    public TreeNode expandBinaryTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if (root.left != null) {
            TreeNode left = root.left;
            root.left = new TreeNode(-1);
            root.left.left = left;
            reverse(left);
        }
        if (root.right != null) {
            TreeNode right = root.right;
            root.right = new TreeNode(-1);
            root.right.right = right;
            reverse(right);
        }
    }


}

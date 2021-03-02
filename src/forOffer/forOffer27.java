package forOffer;

import datastructure.TreeNode;

public class forOffer27 {
    /*Description
    * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    * */

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode left=root.left;
        root.left=root.right;
        root.right=left;
        return root;
    }
}

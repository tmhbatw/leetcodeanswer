package leetcode.leetcode8;

import datastructure.TreeNode;

public class Leetcode701 {
    /*Description
    * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
    * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
    * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
    * */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        insert(root,val);
        return root;
    }

    private void insert(TreeNode root,int val){
        if(root.val<val){
            if(root.right==null)
                root.right=new TreeNode(val);
            else
                insert(root.right,val);
        }
        if(root.val>val){
            if(root.left==null)
                root.left=new TreeNode(val);
            else
                insert(root.left,val);
        }
    }
}

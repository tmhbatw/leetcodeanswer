package leetcode2;

import datastructure.TreeNode;

import java.util.Stack;

public class Leetcode156 {
    /*Description
    * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，
    * 要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
    * */

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null){
            stack.add(root);
            root=root.left;
        }
        TreeNode result=new TreeNode(stack.pop().val);
        TreeNode cur=result;
        while(!stack.empty()){
            TreeNode curr=stack.pop();
            cur.right=new TreeNode(curr.val);
            cur.left=upsideDownBinaryTree(curr.right);
            cur=cur.right;
        }
        return result;
    }
}

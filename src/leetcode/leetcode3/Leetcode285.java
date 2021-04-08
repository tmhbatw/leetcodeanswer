package leetcode.leetcode3;

import datastructure.TreeNode;

import java.util.Stack;

public class Leetcode285 {
    /*Description
    * 给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
    * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
    * */

    Stack<TreeNode> stack=new Stack<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pInRoot=findP(root,p.val);
        if(pInRoot.right!=null){
            TreeNode result=pInRoot.right;
            while(result.left!=null)
                result=result.left;
            return result;
        }
        return stack.empty()?null:stack.peek();
    }

    private TreeNode findP(TreeNode root,int val){
        if(root==null||root.val==val)
            return root;
        if(root.val<val)
            return findP(root.right,val);
        else{
            stack.add(root);
            return findP(root.left,val);
        }
    }
}

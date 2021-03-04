package interview;

import datastructure.TreeNode;

public class Problem4_6 {
    /*Description
    * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
    * 如果指定节点没有对应的“下一个”节点，则返回null。
    * */

    TreeNode pre=null;
    TreeNode result=null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root,p);
        return result;
    }

    private void inorder(TreeNode root,TreeNode p){
        if(result!=null||root==null)
            return ;
        inorder(root.right,p);
        if(root==p){
            result=pre;
            return;
        }
        pre=root;
        inorder(root.left,p);

    }
}

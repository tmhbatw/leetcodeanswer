package interview;

import datastructure.TreeNode;

public class Problem17_12 {
    /*Description
    * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
    * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
    * 返回转换后的单向链表的头节点。
    * */

    TreeNode result=null;
    TreeNode pre=null;
    public TreeNode convertBiNode(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root){
        if(root==null)
            return ;
        dfs(root.left);
        if(pre==null){
            pre=root;
            result=pre;
        }else{
            pre.right=root;
            pre=root;
        }
        dfs(root.right);
    }

}

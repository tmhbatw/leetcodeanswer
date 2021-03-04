package interview;

import datastructure.TreeNode;

public class Problem4_5 {
    /*Description
    * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
     * */

    int val=Integer.MIN_VALUE;
    boolean empty=true;
    boolean result=true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node){
        if(!result||node==null)
            return;
        dfs(node.left);
        if(empty){
            empty=false;
            val=node.val;
        }
        else if(node.val<=val){
            result=false;
            return;
        }
        val=node.val;
        dfs(node.right);
    }

}

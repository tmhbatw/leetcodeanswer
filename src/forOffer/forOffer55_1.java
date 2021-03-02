package forOffer;

import datastructure.TreeNode;

public class forOffer55_1 {
    /*Description
    * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点
    * （含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
    * */

    /*Solution
    * 尝试一下dfs
    * */

    int res=0;
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root,int cur){
        if(root==null){
            res=Math.max(res,cur);
        }
        else{
            dfs(root.left,cur+1);
            dfs(root.right,cur+1);
        }
    }
}

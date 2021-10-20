package forOffer2;

import datastructure.TreeNode;

public class ForOffer53 {

    TreeNode result=null;
    boolean flag=false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root,p);
        return result;
    }

    private void dfs(TreeNode root,TreeNode p){
        if(root==null||result!=null)
            return;
        dfs(root.left,p);
        if(result!=null)
            return;
        if(flag){
            result=root;
            return;
        }
        if(root==p){
            flag=true;
        }
        dfs(root.right,p);
    }
}

package forOffer2;

import datastructure.TreeNode;

public class ForOffer54 {

    int pre=0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.right);
        pre+=root.val;
        root.val=pre;
        dfs(root.left);
    }
}

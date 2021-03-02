package forOffer;

import datastructure.TreeNode;

public class forOffer54 {
    /*Description
    * 给定一棵二叉搜索树，请找出其中第k大的节点。
    * */

    int res=-1,count;
    public int kthLargest(TreeNode root, int k) {
        count=k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if(root==null||res!=-1)
            return;
        dfs(root.right);
        if(count==1){
            count--;
            res=root.val;
            return;
        }else
            count--;
        dfs(root.left);
    }
}

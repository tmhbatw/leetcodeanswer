package leetcode.leetcode3;

import datastructure.TreeNode;

public class Leetcode250 {
    /*Description
    * 给定一个二叉树，统计该二叉树数值相同的子树个数。
    * 同值子树是指该子树的所有节点都拥有相同的数值。
    * */
    int result=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root!=null)
            isUnival(root);
        return result;
    }

    private boolean isUnival(TreeNode root){
        boolean res=true;
        if(root.left!=null){
            if(!isUnival(root.left)||root.left!=null&&root.val!=root.left.val)
                res=false;
        }
        if(root.right!=null){
            if(!isUnival(root.right)||root.right!=null&&root.val!=root.right.val)
                res=false;
        }
        if(res)
            result++;
        return res;
    }
}

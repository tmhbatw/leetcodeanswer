package leetcode.leetcode10;

import datastructure.TreeNode;

public class Leetcode938 {

    int result=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root,low,high);
        return result;
    }

    private void inOrder(TreeNode root, int low, int high){
        if(root==null)
            return ;
        if(root.val<=high&&root.val>=low){
            result+=root.val;
            inOrder(root.left,low,high);
            inOrder(root.right,low,high);
        }
        else if(root.val<low)
            inOrder(root.right,low,high);
        else
            inOrder(root.left,low,high);
    }
}

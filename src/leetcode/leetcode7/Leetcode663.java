package leetcode.leetcode7;

import datastructure.TreeNode;

public class Leetcode663 {
    boolean result=false;
    int sum;
    TreeNode root;
    public boolean checkEqualTree(TreeNode root) {
        sum=sum(root);
        this.root=root;
        if(sum%2==1||sum%2==-1)
            return false;
        sum/=2;
        getSum(root);
        return result;
    }

    private int getSum(TreeNode root){
        if(result||root==null)
            return 0;
        int s=sum(root);
        if(s==sum&&root!=this.root){
            result=true;
        }
        getSum(root.left);
        getSum(root.right);
        return s;
    }

    private int sum(TreeNode root){
        if(root==null)
            return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
}

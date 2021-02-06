package leetcode3;

import datastructure.TreeNode;

public class Leetcode298 {
    /*Description
    * 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
    * 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。
    * 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。
    * */

    int res=0;
    public int longestConsecutive(TreeNode root) {
        if(root==null)
            return 0;
        recursion(root);
        return res;
    }

    private int recursion(TreeNode cur){
        int val=cur.val;
        int result=0;
        if(cur.left!=null){
            int leftVal=recursion(cur.left);
            if(cur.left.val==val+1)
                result=Math.max(leftVal,result);
        }
        if(cur.right!=null){
            int rightVal=recursion(cur.right);
            if(cur.right.val==val+1)
                result=Math.max(rightVal,result);
        }
        System.out.println(val+" "+result);
        this.res=Math.max(this.res,result+1);
        return result;
    }
}

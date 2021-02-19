package leetcode7;

import datastructure.TreeNode;

public class Leetcode687 {
    /*Description
    * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
    * 注意：两个节点之间的路径长度由它们之间的边数表示。
    * */

    int result=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return result;
        recursion(root);
        return result-1;
    }

    private int recursion(TreeNode cur){
        int result=1;
        int length=1;
        if(cur.left!=null){
            int leftTime=recursion(cur.left);
            if(cur.val==cur.left.val){
                result+=leftTime;
                length=Math.max(length,leftTime+1);
            }
        }
        if(cur.right!=null){
            int rightTime=recursion(cur.right);
            if(cur.val==cur.right.val){
                result+=rightTime;
                length=Math.max(length,rightTime+1);
            }
        }
        this.result=Math.max(result,this.result);
        return length;
    }
}

package leetcode.leetcode15;

import datastructure.TreeNode;

public class Leetcode1430 {


    boolean result=false;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        dfs(root,arr,0);
        return result;
    }


    private void dfs(TreeNode root,int[] arr, int index){
        if(index==arr.length) {
            return;
        }
        if(result)
            return;

        if(root==null||root.val!=arr[index])
            return;

        if(index==arr.length-1&&root.left==null&&root.right==null){
            result=true;
            return;
        }
        dfs(root.left,arr,index+1);
        dfs(root.right,arr,index+1);
    }
}

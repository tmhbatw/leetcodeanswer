package leetcode.leetcode12;

import datastructure.TreeNode;

public class Leetcode1145 {


    int[] time=new int[2];
    int x;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x=x;
        dfs(root);
        int mid=n/2;
        return time[0] > mid || time[1] > mid || n - time[0] - time[1] - 1 > mid;
    }

    private int dfs(TreeNode root){

        int left=root.left==null?0:dfs(root.left);
        int right=root.right==null?0:dfs(root.right);


        if(root.val==x) {
            time = new int[]{left,right};
        }

        return left+right+1;
    }

}

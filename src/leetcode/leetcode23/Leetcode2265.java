package leetcode.leetcode23;

import datastructure.TreeNode;

public class Leetcode2265 {

    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] cur = new int[]{left[0]+right[0]+1,left[1]+right[1]+root.val};
        if(cur[1]/cur[0]==root.val)
            result ++;

        return cur;
    }
}

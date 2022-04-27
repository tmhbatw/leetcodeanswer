package leetcode.leetcode23;

import datastructure.TreeNode;

public class Leetcode2236 {

    public boolean checkTree(TreeNode root) {
        return root.val==root.left.val+root.right.val;
    }
}

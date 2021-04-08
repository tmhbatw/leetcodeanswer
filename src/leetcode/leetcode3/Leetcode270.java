package leetcode.leetcode3;

import datastructure.TreeNode;

public class Leetcode270 {
    /*Description
    * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
    * 注意：
    * 给定的目标值 target 是一个浮点数
    * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
    * */

    double result;
    public int closestValue(TreeNode root, double target) {
       result=root.val;
       close(root,target);
       return (int)result;
    }

    private void close(TreeNode root,double target) {
        if (root == null)
            return;
        if (Math.abs(result - target) > Math.abs(root.val - target)) {
            result = root.val;
        }
        if (root.val > target)
            close(root.left, target);
        else
            close(root.right,target);
    }
}

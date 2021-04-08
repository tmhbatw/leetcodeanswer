package leetcode.leetcode3;

import datastructure.TreeNode;

public class Leetcode230 {
    /*Description
    * 给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第k个最小的元素。
    * 说明：
    * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
    * */

    public int kthSmallest(TreeNode root, int k) {
        int leftNumber=getNumber(root.left);
        if(leftNumber==k-1)
            return root.val;
        else if(leftNumber>k-1)
            return kthSmallest(root.left,k);
        return kthSmallest(root.right,k-leftNumber-1);
    }

    private int getNumber(TreeNode root){
        if(root==null)
            return 0;
        return getNumber(root.left)+1+getNumber(root.right);
    }
}

package interview;

import datastructure.TreeNode;

public class Problem4_4 {
    /*Description
    * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     * */

    boolean result=true;
    public boolean isBalanced(TreeNode root) {
        isBan(root);
        return result;
    }

    private int isBan(TreeNode root){
        if(root==null||!result)
            return 0;
        int left=isBan(root.left),right=isBan(root.right);
        if(Math.abs(left-right)>1){
            result=false;
            return 0;
        }
        return Math.max(left,right)+1;
    }
}

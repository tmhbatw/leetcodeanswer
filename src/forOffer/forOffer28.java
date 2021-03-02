package forOffer;

import datastructure.TreeNode;

public class forOffer28 {
    /*Description
    * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
    * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    * */

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSame(root.left,root.right);
    }

    private boolean isSame(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null)
            return false;
        if(left.val==right.val)
            return isSame(left.left,right.right)&&isSame(left.right,right.left);
        return false;
    }
}

package leetcode.leetcode6;

import datastructure.TreeNode;

public class Leetcode572 {
    /*Description
    * 给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。
    * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    * */

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&&t==null)
            return true;
        if(s==null||t==null)
            return false;
        if(s.val==t.val){
            if(isTree(s,t))
                return true;
        }
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    private boolean isTree(TreeNode s,TreeNode t){
        if(s==null&&t==null)
            return true;
        if(s==null||t==null)
            return false;
        if(s.val!=t.val){
            return false;
        }
        return isTree(s.left,t.left)&&isTree(s.right,t.right);
    }
}

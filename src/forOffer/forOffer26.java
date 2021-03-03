package forOffer;

import datastructure.TreeNode;

public class forOffer26 {
    /*Description
    * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
    * */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null)
            return false;
        if(A==null)
            return false;
        if(A.val==B.val){
            if(isSame(A,B))
                return true;
        }
        return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    private boolean isSame(TreeNode A,TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null)
            return false;
        if(A.val==B.val) {
            return isSame(A.left, B.left) && isSame(A.right, B.right);
        }
        return false;
    }
}
